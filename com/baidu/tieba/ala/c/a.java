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
    private RelativeLayout fVu;
    private TextView fVv;
    private TextView fVw;
    private RoundRectRelativeLayout fVx;
    private C0589a fVy;
    private List<Integer> fVz;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bJJ() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        bJK();
        this.fVu = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bEQ();
            }
        });
        this.fVv = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fVv.setText(a.i.sdk_choose_custom_date_tip);
        this.fVw = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.fVw.setVisibility(0);
        this.fVx = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVx.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.fVx.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.fVz.size()) {
                    a.this.fVW = ((Integer) a.this.fVz.get(i)).intValue();
                    a.this.fVy.tx(a.this.fVW);
                }
            }
        });
        this.fVy = new C0589a(this.fVS.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fVy);
        this.fVy.dA(this.fVW);
        this.fVy.setData(this.fVz);
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
    public void aF(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.fVW > 0) {
            H(this.fVW, false);
        } else {
            this.fVS.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void tw(int i) {
        super.tw(i);
        H(i, true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.fxG.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.fxG.getEditView().setSelection(this.fxG.getEditView().getText().length());
        }
        this.fxG.setSendEnabled(true);
    }

    private void H(int i, boolean z) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("date_custom", z);
            jSONObject.put("date_value", i);
            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.fVS.setResult(-1, intent);
        this.fVS.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bJK() {
        if (this.fVz == null) {
            this.fVz = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.fVz.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0589a extends BaseAdapter {
        private List<Integer> dataList;
        private int fVB;
        private Context mContext;

        public C0589a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void dA(int i) {
            this.fVB = i;
        }

        public void tx(int i) {
            if (this.fVB != i) {
                this.fVB = i;
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
        /* renamed from: ty */
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
                bVar2.fVC = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fVD = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fVE = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.fVD.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.fVB == item.intValue()) {
                    bVar.fVE.setVisibility(0);
                } else {
                    bVar.fVE.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout fVC;
        public TextView fVD;
        public ImageView fVE;

        private b() {
        }
    }
}
