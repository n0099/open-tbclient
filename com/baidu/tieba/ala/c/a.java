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
    private RelativeLayout gGc;
    private TextView gGd;
    private TextView gGe;
    private RoundRectRelativeLayout gGf;
    private C0646a gGg;
    private List<Integer> gGh;
    private BdListView mListView;

    public a(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bUz() {
        return a.g.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        bUA();
        this.gGc = (RelativeLayout) this.mRootView.findViewById(a.f.choose_bottom_layout);
        this.gGc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bOV();
            }
        });
        this.gGd = (TextView) this.mRootView.findViewById(a.f.choose_bottom_tip);
        this.gGd.setText(a.h.sdk_choose_custom_date_tip);
        this.gGe = (TextView) this.mRootView.findViewById(a.f.choose_num_desc);
        this.gGe.setVisibility(0);
        this.gGf = (RoundRectRelativeLayout) this.mRootView.findViewById(a.f.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGf.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds178);
        this.gGf.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.gGh.size()) {
                    a.this.gGD = ((Integer) a.this.gGh.get(i)).intValue();
                    a.this.gGg.vD(a.this.gGD);
                }
            }
        });
        this.gGg = new C0646a(this.gGA.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gGg);
        this.gGg.dU(this.gGD);
        this.gGg.setData(this.gGh);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void j(TextView textView) {
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
    public void aT(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gGD > 0) {
            J(this.gGD, false);
        } else {
            this.gGA.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void vC(int i) {
        super.vC(i);
        J(i, true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.gfT.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.gfT.getEditView().setSelection(this.gfT.getEditView().getText().length());
        }
        this.gfT.setSendEnabled(true);
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
        this.gGA.setResult(-1, intent);
        this.gGA.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bUA() {
        if (this.gGh == null) {
            this.gGh = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.gGh.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0646a extends BaseAdapter {
        private List<Integer> dataList;
        private int gGj;
        private Context mContext;

        public C0646a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void dU(int i) {
            this.gGj = i;
        }

        public void vD(int i) {
            if (this.gGj != i) {
                this.gGj = i;
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
        /* renamed from: vE */
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
                bVar2.gGk = (RelativeLayout) view.findViewById(a.f.item_root);
                bVar2.gGl = (TextView) view.findViewById(a.f.item_num_title);
                bVar2.gGm = (ImageView) view.findViewById(a.f.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.gGl.setText(String.format(this.mContext.getResources().getString(a.h.sdk_choose_hour_suffix), item));
                if (this.gGj == item.intValue()) {
                    bVar.gGm.setVisibility(0);
                } else {
                    bVar.gGm.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout gGk;
        public TextView gGl;
        public ImageView gGm;

        private b() {
        }
    }
}
