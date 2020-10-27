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
    private static int gsb;
    private CommonEmptyView boq;
    private BdGridView gsc;
    private a gsd;
    private List<g> gse;
    private g gsf;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        gsb = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bOV() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gsc = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.gsc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gsf = (g) b.this.gse.get(i);
                b.this.gsp = b.this.gsf.Fs();
                b.this.gsd.GM(b.this.gsp);
            }
        });
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
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
    public void aR(int i, String str) {
        apc();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gsf != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gsf.Ft());
                jSONObject.put("gift_url", this.gsf.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gsf.Fs());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gso.setResult(-1, intent);
        }
        this.gso.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.IO())) {
            showNoDataView();
            return;
        }
        this.gsc.setVisibility(0);
        this.boq.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.z.a.Pq().bsy.aOL.aRo;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.z.a.Pq().bsy.aOL.aRn;
        } else {
            i = (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) ? com.baidu.live.z.a.Pq().bsy.aOL.aRp : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.IO().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gse = next.FT();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gse)) {
            showNoDataView();
        } else {
            bOX();
        }
    }

    private void apc() {
        bME();
    }

    private void showNoDataView() {
        bME();
    }

    private void bME() {
        this.gsc.setVisibility(8);
        this.boq.setVisibility(0);
        this.boq.reset();
        this.boq.setTitle(a.i.sdk_net_fail_tip_rank);
        this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.boq.setVisibility(8);
                b.this.bR(b.this.boq);
            }
        });
        this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.boq.setVisibility(0);
    }

    private void bOX() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gse) {
            if (gVar != null && gVar.Fs() != null) {
                if (gVar.Fs().equals(this.gsp)) {
                    this.gsf = gVar;
                }
                if (!ListUtils.isEmpty(this.fSn) && this.fSn.contains(gVar.Fs())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gse.removeAll(arrayList);
        }
        this.gsd = new a(this.gso.getPageContext());
        this.gsc.setAdapter((ListAdapter) this.gsd);
        this.gsd.GL(this.gsp);
        this.gsd.setData(this.gse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fSm;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void GL(String str) {
            this.fSm = str;
        }

        public void GM(String str) {
            if (this.fSm == null || !this.fSm.equals(str)) {
                this.fSm = str;
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
        /* renamed from: ef */
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
            C0623b c0623b;
            if (view == null) {
                C0623b c0623b2 = new C0623b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.gsb;
                layoutParams.height = b.gsb;
                view.setLayoutParams(layoutParams);
                c0623b2.gsh = (FrameLayout) view.findViewById(a.g.item_root);
                c0623b2.gsi = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0623b2.gsi.setDefaultBgResource(a.f.icon_live_gift_default);
                c0623b2.gsi.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0623b2.gsi.setAutoChangeStyle(false);
                c0623b2.gsj = (TextView) view.findViewById(a.g.item_gift_title);
                c0623b2.aWX = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0623b2);
                c0623b = c0623b2;
            } else {
                c0623b = (C0623b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0623b.gsi.startLoad(item.getThumbnail_url(), 10, false);
                c0623b.gsj.setText(item.Ft());
                b(c0623b.aWX, item.getPrice());
                if (item.Fs().equals(this.fSm)) {
                    c0623b.gsh.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0623b.gsh.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void b(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.z.a.Pq().bmJ.aLG) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0623b {
        public TextView aWX;
        public FrameLayout gsh;
        public TbImageView gsi;
        public TextView gsj;

        private C0623b() {
        }
    }
}
