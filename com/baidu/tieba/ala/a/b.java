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
    private static int exU;
    private CommonEmptyView ewe;
    private BdGridView exV;
    private a exW;
    private List<g> exX;
    private g exY;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        exU = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.a.d
    protected int getLayoutResId() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.a.d
    protected void initView() {
        this.exV = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.exV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.exY = (g) b.this.exX.get(i);
                b.this.eyk = b.this.exY.rx();
                b.this.exW.yg(b.this.eyk);
            }
        });
        this.ewe = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
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
        Qu();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.exY != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.exY.ry());
                jSONObject.put("gift_url", this.exY.rA());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.exY.rx());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.eyi.setResult(-1, intent);
        }
        this.eyi.finish();
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.uG())) {
            showNoDataView();
            return;
        }
        this.exV.setVisibility(0);
        this.ewe.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.zl().axD.ade.aeO;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.zl().axD.ade.aeN;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.zl().axD.ade.aeP : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.uG().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.exX = next.rY();
                break;
            }
        }
        if (ListUtils.isEmpty(this.exX)) {
            showNoDataView();
        } else {
            bed();
        }
    }

    private void Qu() {
        aiu();
    }

    private void showNoDataView() {
        aiu();
    }

    private void aiu() {
        this.exV.setVisibility(8);
        this.ewe.setVisibility(0);
        this.ewe.reset();
        this.ewe.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ewe.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ewe.setVisibility(8);
                b.this.bt(b.this.ewe);
            }
        });
        this.ewe.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewe.setVisibility(0);
    }

    private void bed() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.exX) {
            if (gVar != null && gVar.rx() != null) {
                if (gVar.rx().equals(this.eyk)) {
                    this.exY = gVar;
                }
                if (!ListUtils.isEmpty(this.ehc) && this.ehc.contains(gVar.rx())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.exX.removeAll(arrayList);
        }
        this.exW = new a(this.eyi.getPageContext());
        this.exV.setAdapter((ListAdapter) this.exW);
        this.exW.yf(this.eyk);
        this.exW.setData(this.exX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String ehb;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void yf(String str) {
            this.ehb = str;
        }

        public void yg(String str) {
            if (this.ehb == null || !this.ehb.equals(str)) {
                this.ehb = str;
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
                layoutParams.width = b.exU;
                layoutParams.height = b.exU;
                view.setLayoutParams(layoutParams);
                c0421b2.eya = (FrameLayout) view.findViewById(a.g.item_root);
                c0421b2.eyb = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0421b2.eyb.setDefaultBgResource(a.f.icon_live_gift_default);
                c0421b2.eyb.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0421b2.eyb.setAutoChangeStyle(false);
                c0421b2.eyc = (TextView) view.findViewById(a.g.item_gift_title);
                c0421b2.aiZ = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0421b2);
                c0421b = c0421b2;
            } else {
                c0421b = (C0421b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0421b.eyb.startLoad(item.rA(), 10, false);
                c0421b.eyc.setText(item.ry());
                a(c0421b.aiZ, item.getPrice());
                if (item.rx().equals(this.ehb)) {
                    c0421b.eya.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0421b.eya.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.zl().awC.aaq) {
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
        public TextView aiZ;
        public FrameLayout eya;
        public TbImageView eyb;
        public TextView eyc;

        private C0421b() {
        }
    }
}
