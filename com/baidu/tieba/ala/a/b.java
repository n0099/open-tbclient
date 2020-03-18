package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {
    private static int eys;
    private CommonEmptyView ewA;
    private BdGridView eyt;
    private a eyu;
    private List<g> eyv;
    private g eyw;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        eys = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.a.d
    protected int getLayoutResId() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.a.d
    protected void initView() {
        this.eyt = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.eyt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.eyw = (g) b.this.eyv.get(i);
                b.this.eyH = b.this.eyw.rC();
                b.this.eyu.yg(b.this.eyH);
            }
        });
        this.ewA = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void d(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        d(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void aj(int i, String str) {
        Qx();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.eyw != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.eyw.rD());
                jSONObject.put("gift_url", this.eyw.rF());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.eyw.rC());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.eyF.setResult(-1, intent);
        }
        this.eyF.finish();
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.uL())) {
            showNoDataView();
            return;
        }
        this.eyt.setVisibility(0);
        this.ewA.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.zs().axR.ado.aeY;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.zs().axR.ado.aeX;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.zs().axR.ado.aeZ : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.uL().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.eyv = next.sd();
                break;
            }
        }
        if (ListUtils.isEmpty(this.eyv)) {
            showNoDataView();
        } else {
            bei();
        }
    }

    private void Qx() {
        aix();
    }

    private void showNoDataView() {
        aix();
    }

    private void aix() {
        this.eyt.setVisibility(8);
        this.ewA.setVisibility(0);
        this.ewA.reset();
        this.ewA.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ewA.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ewA.setVisibility(8);
                b.this.bt(b.this.ewA);
            }
        });
        this.ewA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewA.setVisibility(0);
    }

    private void bei() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.eyv) {
            if (gVar != null && gVar.rC() != null) {
                if (gVar.rC().equals(this.eyH)) {
                    this.eyw = gVar;
                }
                if (!ListUtils.isEmpty(this.ehs) && this.ehs.contains(gVar.rC())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.eyv.removeAll(arrayList);
        }
        this.eyu = new a(this.eyF.getPageContext());
        this.eyt.setAdapter((ListAdapter) this.eyu);
        this.eyu.yf(this.eyH);
        this.eyu.setData(this.eyv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String ehr;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void yf(String str) {
            this.ehr = str;
        }

        public void yg(String str) {
            if (this.ehr == null || !this.ehr.equals(str)) {
                this.ehr = str;
                notifyDataSetChanged();
            }
        }

        public void setData(List<g> list) {
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
        /* renamed from: by */
        public g getItem(int i) {
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
            C0421b c0421b;
            if (view == null) {
                C0421b c0421b2 = new C0421b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.eys;
                layoutParams.height = b.eys;
                view.setLayoutParams(layoutParams);
                c0421b2.eyy = (FrameLayout) view.findViewById(a.g.item_root);
                c0421b2.eyz = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0421b2.eyz.setDefaultBgResource(a.f.icon_live_gift_default);
                c0421b2.eyz.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0421b2.eyz.setAutoChangeStyle(false);
                c0421b2.eyA = (TextView) view.findViewById(a.g.item_gift_title);
                c0421b2.ajj = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0421b2);
                c0421b = c0421b2;
            } else {
                c0421b = (C0421b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0421b.eyz.startLoad(item.rF(), 10, false);
                c0421b.eyA.setText(item.rD());
                a(c0421b.ajj, item.getPrice());
                if (item.rC().equals(this.ehr)) {
                    c0421b.eyy.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0421b.eyy.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.zs().awM.aaA) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0421b {
        public TextView ajj;
        public TextView eyA;
        public FrameLayout eyy;
        public TbImageView eyz;

        private C0421b() {
        }
    }
}
