package com.baidu.tieba.ala.c;

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
    private RelativeLayout ghN;
    private TextView ghO;
    private TextView ghP;
    private RoundRectRelativeLayout ghQ;
    private C0606a ghR;
    private List<Integer> ghS;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bMt() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        bMu();
        this.ghN = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.ghN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bHC();
            }
        });
        this.ghO = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.ghO.setText(a.i.sdk_choose_custom_date_tip);
        this.ghP = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.ghP.setVisibility(0);
        this.ghQ = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ghQ.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.ghQ.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.ghS.size()) {
                    a.this.gip = ((Integer) a.this.ghS.get(i)).intValue();
                    a.this.ghR.tV(a.this.gip);
                }
            }
        });
        this.ghR = new C0606a(this.gim.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.ghR);
        this.ghR.dF(this.gip);
        this.ghR.setData(this.ghS);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void f(TextView textView) {
        textView.setText(a.i.sdk_choose_date_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.i.sdk_choose_input_date_hint));
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
    }

    @Override // com.baidu.tieba.ala.c.d
    public void aQ(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gip > 0) {
            J(this.gip, false);
        } else {
            this.gim.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void tU(int i) {
        super.tU(i);
        J(i, true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.fJP.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.fJP.getEditView().setSelection(this.fJP.getEditView().getText().length());
        }
        this.fJP.setSendEnabled(true);
    }

    private void J(int i, boolean z) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("date_custom", z);
            jSONObject.put("date_value", i);
            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.gim.setResult(-1, intent);
        this.gim.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bMu() {
        if (this.ghS == null) {
            this.ghS = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.ghS.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0606a extends BaseAdapter {
        private List<Integer> dataList;
        private int ghU;
        private Context mContext;

        public C0606a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void dF(int i) {
            this.ghU = i;
        }

        public void tV(int i) {
            if (this.ghU != i) {
                this.ghU = i;
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
        /* renamed from: tW */
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
                bVar2.ghV = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.ghW = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.ghX = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.ghW.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.ghU == item.intValue()) {
                    bVar.ghX.setVisibility(0);
                } else {
                    bVar.ghX.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout ghV;
        public TextView ghW;
        public ImageView ghX;

        private b() {
        }
    }
}
