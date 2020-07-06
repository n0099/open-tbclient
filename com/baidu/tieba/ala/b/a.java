package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {
    private RelativeLayout fBF;
    private TextView fBG;
    private TextView fBH;
    private RoundRectRelativeLayout fBI;
    private C0536a fBJ;
    private List<Integer> fBK;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bwj() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        bwk();
        this.fBF = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.brB();
            }
        });
        this.fBG = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fBG.setText(a.i.sdk_choose_custom_date_tip);
        this.fBH = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.fBH.setVisibility(0);
        this.fBI = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBI.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.fBI.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.fBK.size()) {
                    a.this.fCh = ((Integer) a.this.fBK.get(i)).intValue();
                    a.this.fBJ.qD(a.this.fCh);
                }
            }
        });
        this.fBJ = new C0536a(this.fCd.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fBJ);
        this.fBJ.bI(this.fCh);
        this.fBJ.setData(this.fBK);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(TextView textView) {
        textView.setText(a.i.sdk_choose_date_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.i.sdk_choose_input_date_hint));
    }

    @Override // com.baidu.tieba.ala.b.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
    }

    @Override // com.baidu.tieba.ala.b.d
    public void aF(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fCh > 0) {
            G(this.fCh, false);
        } else {
            this.fCd.finish();
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void qC(int i) {
        super.qC(i);
        G(i, true);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.fec.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.fec.getEditView().setSelection(this.fec.getEditView().getText().length());
        }
        this.fec.setSendEnabled(true);
    }

    private void G(int i, boolean z) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("date_custom", z);
            jSONObject.put("date_value", i);
            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.fCd.setResult(-1, intent);
        this.fCd.finish();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bwk() {
        if (this.fBK == null) {
            this.fBK = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.fBK.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0536a extends BaseAdapter {
        private List<Integer> dataList;
        private int fBM;
        private Context mContext;

        public C0536a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void bI(int i) {
            this.fBM = i;
        }

        public void qD(int i) {
            if (this.fBM != i) {
                this.fBM = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<Integer> list) {
            this.dataList = new ArrayList(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dataList == null) {
                return 0;
            }
            return this.dataList.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: qE */
        public Integer getItem(int i) {
            if (this.dataList == null) {
                return null;
            }
            return this.dataList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_num_and_date_item, viewGroup, false);
                bVar2.fBN = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fBO = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fBP = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.fBO.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.fBM == item.intValue()) {
                    bVar.fBP.setVisibility(0);
                } else {
                    bVar.fBP.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        public RelativeLayout fBN;
        public TextView fBO;
        public ImageView fBP;

        private b() {
        }
    }
}
