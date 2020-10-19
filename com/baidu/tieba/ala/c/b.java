package com.baidu.tieba.ala.c;

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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends d {
    private static int ghY;
    private CommonEmptyView bmS;
    private BdGridView ghZ;
    private a gia;
    private List<g> gib;
    private g gic;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        ghY = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bMt() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.ghZ = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.ghZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gic = (g) b.this.gib.get(i);
                b.this.gin = b.this.gic.Fd();
                b.this.gia.Gn(b.this.gin);
            }
        });
        this.bmS = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void f(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void aQ(int i, String str) {
        ani();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gic != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gic.Fe());
                jSONObject.put("gift_url", this.gic.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gic.Fd());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gim.setResult(-1, intent);
        }
        this.gim.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Iv())) {
            showNoDataView();
            return;
        }
        this.ghZ.setVisibility(0);
        this.bmS.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.x.a.OS().bqJ.aOg.aQD;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.x.a.OS().bqJ.aOg.aQC;
        } else {
            i = (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) ? com.baidu.live.x.a.OS().bqJ.aOg.aQE : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.Iv().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gib = next.FE();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gib)) {
            showNoDataView();
        } else {
            bMv();
        }
    }

    private void ani() {
        bKc();
    }

    private void showNoDataView() {
        bKc();
    }

    private void bKc() {
        this.ghZ.setVisibility(8);
        this.bmS.setVisibility(0);
        this.bmS.reset();
        this.bmS.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bmS.setVisibility(8);
                b.this.bO(b.this.bmS);
            }
        });
        this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bmS.setVisibility(0);
    }

    private void bMv() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gib) {
            if (gVar != null && gVar.Fd() != null) {
                if (gVar.Fd().equals(this.gin)) {
                    this.gic = gVar;
                }
                if (!ListUtils.isEmpty(this.fJT) && this.fJT.contains(gVar.Fd())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gib.removeAll(arrayList);
        }
        this.gia = new a(this.gim.getPageContext());
        this.ghZ.setAdapter((ListAdapter) this.gia);
        this.gia.Gm(this.gin);
        this.gia.setData(this.gib);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fJS;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void Gm(String str) {
            this.fJS = str;
        }

        public void Gn(String str) {
            if (this.fJS == null || !this.fJS.equals(str)) {
                this.fJS = str;
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
        /* renamed from: ee */
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
            C0607b c0607b;
            if (view == null) {
                C0607b c0607b2 = new C0607b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.ghY;
                layoutParams.height = b.ghY;
                view.setLayoutParams(layoutParams);
                c0607b2.gif = (FrameLayout) view.findViewById(a.g.item_root);
                c0607b2.gig = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0607b2.gig.setDefaultBgResource(a.f.icon_live_gift_default);
                c0607b2.gig.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0607b2.gig.setAutoChangeStyle(false);
                c0607b2.gih = (TextView) view.findViewById(a.g.item_gift_title);
                c0607b2.aVC = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0607b2);
                c0607b = c0607b2;
            } else {
                c0607b = (C0607b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0607b.gig.startLoad(item.getThumbnail_url(), 10, false);
                c0607b.gih.setText(item.Fe());
                b(c0607b.aVC, item.getPrice());
                if (item.Fd().equals(this.fJS)) {
                    c0607b.gif.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0607b.gif.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void b(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.x.a.OS().blo.aLc) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0607b {
        public TextView aVC;
        public FrameLayout gif;
        public TbImageView gig;
        public TextView gih;

        private C0607b() {
        }
    }
}
