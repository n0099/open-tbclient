package com.baidu.tieba.ala.a;

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
    private RelativeLayout exJ;
    private TextView exK;
    private TextView exL;
    private RoundRectRelativeLayout exM;
    private C0420a exN;
    private List<Integer> exO;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.a.d
    protected int getLayoutResId() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.a.d
    protected void initView() {
        bec();
        this.exJ = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.exJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bbz();
            }
        });
        this.exK = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.exK.setText(a.i.sdk_choose_custom_date_tip);
        this.exL = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.exL.setVisibility(0);
        this.exM = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.exM.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.exM.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.exO.size()) {
                    a.this.eyn = ((Integer) a.this.exO.get(i)).intValue();
                    a.this.exN.pe(a.this.eyn);
                }
            }
        });
        this.exN = new C0420a(this.eyi.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.exN);
        this.exN.bg(this.eyn);
        this.exN.setData(this.exO);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void d(TextView textView) {
        textView.setText(a.i.sdk_choose_date_title);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.i.sdk_choose_input_date_hint));
    }

    @Override // com.baidu.tieba.ala.a.d
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
    }

    @Override // com.baidu.tieba.ala.a.d
    public void aj(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.eyn > 0) {
            y(this.eyn, false);
        } else {
            this.eyi.finish();
        }
    }

    @Override // com.baidu.tieba.ala.a.d
    public void pd(int i) {
        super.pd(i);
        y(i, true);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.egY.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.egY.getEditView().setSelection(this.egY.getEditView().getText().length());
        }
        this.egY.setSendEnabled(true);
    }

    private void y(int i, boolean z) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("date_custom", z);
            jSONObject.put("date_value", i);
            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.eyi.setResult(-1, intent);
        this.eyi.finish();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bec() {
        if (this.exO == null) {
            this.exO = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.exO.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0420a extends BaseAdapter {
        private List<Integer> dataList;
        private int exQ;
        private Context mContext;

        public C0420a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void bg(int i) {
            this.exQ = i;
        }

        public void pe(int i) {
            if (this.exQ != i) {
                this.exQ = i;
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
        /* renamed from: pf */
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
                bVar2.exR = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.exS = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.exT = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.exS.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.exQ == item.intValue()) {
                    bVar.exT.setVisibility(0);
                } else {
                    bVar.exT.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        public RelativeLayout exR;
        public TextView exS;
        public ImageView exT;

        private b() {
        }
    }
}
