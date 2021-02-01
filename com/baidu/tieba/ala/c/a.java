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
/* loaded from: classes11.dex */
public class a extends d {
    private RelativeLayout gPN;
    private TextView gPO;
    private TextView gPP;
    private RoundRectRelativeLayout gPQ;
    private C0619a gPR;
    private List<Integer> gPS;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bTQ() {
        return a.g.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        bTR();
        this.gPN = (RelativeLayout) this.mRootView.findViewById(a.f.choose_bottom_layout);
        this.gPN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bOf();
            }
        });
        this.gPO = (TextView) this.mRootView.findViewById(a.f.choose_bottom_tip);
        this.gPO.setText(a.h.sdk_choose_custom_date_tip);
        this.gPP = (TextView) this.mRootView.findViewById(a.f.choose_num_desc);
        this.gPP.setVisibility(0);
        this.gPQ = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPQ.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds178);
        this.gPQ.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.gPS.size()) {
                    a.this.gQo = ((Integer) a.this.gPS.get(i)).intValue();
                    a.this.gPR.uo(a.this.gQo);
                }
            }
        });
        this.gPR = new C0619a(this.gQl.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gPR);
        this.gPR.co(this.gQo);
        this.gPR.setData(this.gPS);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void l(TextView textView) {
        textView.setText(a.h.sdk_choose_date_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.h.sdk_choose_input_date_hint));
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
    }

    @Override // com.baidu.tieba.ala.c.d
    public void bb(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gQo > 0) {
            J(this.gQo, false);
        } else {
            this.gQl.finish();
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
            this.gnW.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.gnW.getEditView().setSelection(this.gnW.getEditView().getText().length());
        }
        this.gnW.setSendEnabled(true);
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
        this.gQl.setResult(-1, intent);
        this.gQl.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bTR() {
        if (this.gPS == null) {
            this.gPS = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.gPS.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0619a extends BaseAdapter {
        private List<Integer> dataList;
        private int gPU;
        private Context mContext;

        public C0619a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void co(int i) {
            this.gPU = i;
        }

        public void uo(int i) {
            if (this.gPU != i) {
                this.gPU = i;
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
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_choose_num_and_date_item, viewGroup, false);
                bVar2.gPV = (RelativeLayout) view.findViewById(a.f.item_root);
                bVar2.gPW = (TextView) view.findViewById(a.f.item_num_title);
                bVar2.gPX = (ImageView) view.findViewById(a.f.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.gPW.setText(String.format(this.mContext.getResources().getString(a.h.sdk_choose_hour_suffix), item));
                if (this.gPU == item.intValue()) {
                    bVar.gPX.setVisibility(0);
                } else {
                    bVar.gPX.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes11.dex */
    private class b {
        public RelativeLayout gPV;
        public TextView gPW;
        public ImageView gPX;

        private b() {
        }
    }
}
