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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
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
    private RelativeLayout fcG;
    private TextView fcH;
    private TextView fcI;
    private RoundRectRelativeLayout fcJ;
    private C0481a fcK;
    private List<Integer> fcL;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bnu() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        bnv();
        this.fcG = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fcG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bjE();
            }
        });
        this.fcH = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fcH.setText(a.i.sdk_choose_custom_date_tip);
        this.fcI = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.fcI.setVisibility(0);
        this.fcJ = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fcJ.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.fcJ.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.fcL.size()) {
                    a.this.fdi = ((Integer) a.this.fcL.get(i)).intValue();
                    a.this.fcK.pB(a.this.fdi);
                }
            }
        });
        this.fcK = new C0481a(this.fde.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fcK);
        this.fcK.bt(this.fdi);
        this.fcK.setData(this.fcL);
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
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
    }

    @Override // com.baidu.tieba.ala.b.d
    public void ay(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fdi > 0) {
            B(this.fdi, false);
        } else {
            this.fde.finish();
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void pA(int i) {
        super.pA(i);
        B(i, true);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.eHj.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.eHj.getEditView().setSelection(this.eHj.getEditView().getText().length());
        }
        this.eHj.setSendEnabled(true);
    }

    private void B(int i, boolean z) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("date_custom", z);
            jSONObject.put("date_value", i);
            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.fde.setResult(-1, intent);
        this.fde.finish();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bnv() {
        if (this.fcL == null) {
            this.fcL = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.fcL.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0481a extends BaseAdapter {
        private List<Integer> dataList;
        private int fcN;
        private Context mContext;

        public C0481a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void bt(int i) {
            this.fcN = i;
        }

        public void pB(int i) {
            if (this.fcN != i) {
                this.fcN = i;
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
        /* renamed from: pC */
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
                bVar2.fcO = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fcP = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fcQ = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.fcP.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.fcN == item.intValue()) {
                    bVar.fcQ.setVisibility(0);
                } else {
                    bVar.fcQ.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        public RelativeLayout fcO;
        public TextView fcP;
        public ImageView fcQ;

        private b() {
        }
    }
}
