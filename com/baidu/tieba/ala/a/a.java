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
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class a extends d {
    private RelativeLayout erZ;
    private TextView esa;
    private TextView esb;
    private RoundRectRelativeLayout esc;
    private C0407a esd;
    private List<Integer> ese;
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
        bbp();
        this.erZ = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.erZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aYN();
            }
        });
        this.esa = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.esa.setText(a.i.sdk_choose_custom_date_tip);
        this.esb = (TextView) this.mRootView.findViewById(a.g.choose_num_desc);
        this.esb.setVisibility(0);
        this.esc = (RoundRectRelativeLayout) this.mRootView.findViewById(a.g.choose_gift_list_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.esc.getLayoutParams();
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds178);
        this.esc.setLayoutParams(layoutParams);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < a.this.ese.size()) {
                    a.this.esB = ((Integer) a.this.ese.get(i)).intValue();
                    a.this.esd.oM(a.this.esB);
                }
            }
        });
        this.esd = new C0407a(this.esx.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.esd);
        this.esd.aZ(this.esB);
        this.esd.setData(this.ese);
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
    public void ag(int i, String str) {
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.esB > 0) {
            y(this.esB, false);
        } else {
            this.esx.finish();
        }
    }

    @Override // com.baidu.tieba.ala.a.d
    public void oL(int i) {
        super.oL(i);
        y(i, true);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 24) {
            this.ecy.getEditView().setText(SoUtils.SO_EVENT_ID_DEFAULT);
            this.ecy.getEditView().setSelection(this.ecy.getEditView().getText().length());
        }
        this.ecy.setSendEnabled(true);
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
        this.esx.setResult(-1, intent);
        this.esx.finish();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    private void bbp() {
        if (this.ese == null) {
            this.ese = new ArrayList();
        }
        for (int i = 2; i <= 12; i++) {
            if (i % 2 == 0) {
                this.ese.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0407a extends BaseAdapter {
        private List<Integer> cLa;
        private int esg;
        private Context mContext;

        public C0407a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void aZ(int i) {
            this.esg = i;
        }

        public void oM(int i) {
            if (this.esg != i) {
                this.esg = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<Integer> list) {
            this.cLa = new ArrayList(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cLa == null) {
                return 0;
            }
            return this.cLa.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oN */
        public Integer getItem(int i) {
            if (this.cLa == null) {
                return null;
            }
            return this.cLa.get(i);
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
                bVar2.esh = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.esi = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.esj = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            Integer item = getItem(i);
            if (item != null) {
                bVar.esi.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_hour_suffix), item));
                if (this.esg == item.intValue()) {
                    bVar.esj.setVisibility(0);
                } else {
                    bVar.esj.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        public RelativeLayout esh;
        public TextView esi;
        public ImageView esj;

        private b() {
        }
    }
}
