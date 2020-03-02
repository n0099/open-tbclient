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
    private C0420a exA;
    private List<Integer> exB;
    private RelativeLayout exw;
    private TextView exx;
    private TextView exy;
    private RoundRectRelativeLayout exz;
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
        beb();
        this.exw = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.exw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bby();
            }
        });
        this.exx = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.exx.setText(a.i.sdk_choose_custom_date_tip);
        this.exy = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.exy.setVisibility(0);
        this.exz = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.exz.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.exz.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.exB.size()) {
                    a.this.exY = ((Integer) a.this.exB.get(i)).intValue();
                    a.this.exA.pe(a.this.exY);
                }
            }
        });
        this.exA = new C0420a(this.exU.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.exA);
        this.exA.bg(this.exY);
        this.exA.setData(this.exB);
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
        if (this.exY > 0) {
            y(this.exY, false);
        } else {
            this.exU.finish();
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
            this.egL.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.egL.getEditView().setSelection(this.egL.getEditView().getText().length());
        }
        this.egL.setSendEnabled(true);
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
        this.exU.setResult(-1, intent);
        this.exU.finish();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void beb() {
        if (this.exB == null) {
            this.exB = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.exB.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0420a extends BaseAdapter {
        private List<Integer> dataList;
        private int exD;
        private Context mContext;

        public C0420a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void bg(int i) {
            this.exD = i;
        }

        public void pe(int i) {
            if (this.exD != i) {
                this.exD = i;
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
                bVar2.exE = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.exF = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.exG = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.exF.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.exD == item.intValue()) {
                    bVar.exG.setVisibility(0);
                } else {
                    bVar.exG.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        public RelativeLayout exE;
        public TextView exF;
        public ImageView exG;

        private b() {
        }
    }
}
