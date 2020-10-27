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
    private RelativeLayout grQ;
    private TextView grR;
    private TextView grS;
    private RoundRectRelativeLayout grT;
    private C0622a grU;
    private List<Integer> grV;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bOV() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        bOW();
        this.grQ = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.grQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bJt();
            }
        });
        this.grR = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.grR.setText(a.i.sdk_choose_custom_date_tip);
        this.grS = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.grS.setVisibility(0);
        this.grT = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grT.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.grT.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.grV.size()) {
                    a.this.gsr = ((Integer) a.this.grV.get(i)).intValue();
                    a.this.grU.uo(a.this.gsr);
                }
            }
        });
        this.grU = new C0622a(this.gso.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.grU);
        this.grU.dF(this.gsr);
        this.grU.setData(this.grV);
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
    public void aR(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gsr > 0) {
            J(this.gsr, false);
        } else {
            this.gso.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void un(int i) {
        super.un(i);
        J(i, true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.fSj.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.fSj.getEditView().setSelection(this.fSj.getEditView().getText().length());
        }
        this.fSj.setSendEnabled(true);
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
        this.gso.setResult(-1, intent);
        this.gso.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bOW() {
        if (this.grV == null) {
            this.grV = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.grV.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0622a extends BaseAdapter {
        private List<Integer> dataList;
        private int grX;
        private Context mContext;

        public C0622a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void dF(int i) {
            this.grX = i;
        }

        public void uo(int i) {
            if (this.grX != i) {
                this.grX = i;
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
        /* renamed from: up */
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
                bVar2.grY = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.grZ = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.gsa = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.grZ.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.grX == item.intValue()) {
                    bVar.gsa.setVisibility(0);
                } else {
                    bVar.gsa.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout grY;
        public TextView grZ;
        public ImageView gsa;

        private b() {
        }
    }
}
