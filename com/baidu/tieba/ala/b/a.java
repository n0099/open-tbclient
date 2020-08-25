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
/* loaded from: classes7.dex */
public class a extends d {
    private RelativeLayout fSg;
    private TextView fSh;
    private TextView fSi;
    private RoundRectRelativeLayout fSj;
    private C0593a fSk;
    private List<Integer> fSl;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bIA() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        bIB();
        this.fSg = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bDC();
            }
        });
        this.fSh = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fSh.setText(a.i.sdk_choose_custom_date_tip);
        this.fSi = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.fSi.setVisibility(0);
        this.fSj = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fSj.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.fSj.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.fSl.size()) {
                    a.this.fSI = ((Integer) a.this.fSl.get(i)).intValue();
                    a.this.fSk.te(a.this.fSI);
                }
            }
        });
        this.fSk = new C0593a(this.fSE.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fSk);
        this.fSk.dw(this.fSI);
        this.fSk.setData(this.fSl);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void f(TextView textView) {
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
        if (this.fSI > 0) {
            H(this.fSI, false);
        } else {
            this.fSE.finish();
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void td(int i) {
        super.td(i);
        H(i, true);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.fur.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.fur.getEditView().setSelection(this.fur.getEditView().getText().length());
        }
        this.fur.setSendEnabled(true);
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
        this.fSE.setResult(-1, intent);
        this.fSE.finish();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bIB() {
        if (this.fSl == null) {
            this.fSl = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.fSl.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0593a extends BaseAdapter {
        private List<Integer> dataList;
        private int fSn;
        private Context mContext;

        public C0593a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void dw(int i) {
            this.fSn = i;
        }

        public void te(int i) {
            if (this.fSn != i) {
                this.fSn = i;
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
        /* renamed from: tf */
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
                bVar2.fSo = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fSp = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fSq = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.fSp.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.fSn == item.intValue()) {
                    bVar.fSq.setVisibility(0);
                } else {
                    bVar.fSq.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        public RelativeLayout fSo;
        public TextView fSp;
        public ImageView fSq;

        private b() {
        }
    }
}
