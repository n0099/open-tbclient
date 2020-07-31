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
/* loaded from: classes4.dex */
public class a extends d {
    private RelativeLayout fGP;
    private TextView fGQ;
    private TextView fGR;
    private RoundRectRelativeLayout fGS;
    private C0547a fGT;
    private List<Integer> fGU;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bzx() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        bzy();
        this.fGP = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fGP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.buH();
            }
        });
        this.fGQ = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fGQ.setText(a.i.sdk_choose_custom_date_tip);
        this.fGR = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.fGR.setVisibility(0);
        this.fGS = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fGS.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.fGS.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.fGU.size()) {
                    a.this.fHr = ((Integer) a.this.fGU.get(i)).intValue();
                    a.this.fGT.qS(a.this.fHr);
                }
            }
        });
        this.fGT = new C0547a(this.fHn.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fGT);
        this.fGT.bK(this.fHr);
        this.fGT.setData(this.fGU);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void g(TextView textView) {
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
    public void aH(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fHr > 0) {
            G(this.fHr, false);
        } else {
            this.fHn.finish();
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void qR(int i) {
        super.qR(i);
        G(i, true);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.fiV.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.fiV.getEditView().setSelection(this.fiV.getEditView().getText().length());
        }
        this.fiV.setSendEnabled(true);
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
        this.fHn.setResult(-1, intent);
        this.fHn.finish();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bzy() {
        if (this.fGU == null) {
            this.fGU = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.fGU.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0547a extends BaseAdapter {
        private List<Integer> dataList;
        private int fGW;
        private Context mContext;

        public C0547a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void bK(int i) {
            this.fGW = i;
        }

        public void qS(int i) {
            if (this.fGW != i) {
                this.fGW = i;
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
        /* renamed from: qT */
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
                bVar2.fGX = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fGY = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fGZ = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.fGY.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.fGW == item.intValue()) {
                    bVar.fGZ.setVisibility(0);
                } else {
                    bVar.fGZ.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout fGX;
        public TextView fGY;
        public ImageView fGZ;

        private b() {
        }
    }
}
