package com.baidu.tieba.ala;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.s;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.d;
import com.baidu.tieba.ala.f.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView aKJ;
    private String aQi;
    private FrameLayout bAv;
    private TextView cBd;
    private View eHd;
    private LinearLayout eHe;
    private com.baidu.tieba.ala.data.d eIA;
    private com.baidu.tieba.ala.f.e eIB;
    private CustomMessageListener eIC = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k eID = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.f.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.f.k
        public void as(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
    private TextView eIv;
    private TextView eIw;
    private TextView eIx;
    private BdListView eIy;
    private a eIz;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            if (StringUtils.isNullObject(this.mRedPacketId)) {
                finish();
                return;
            }
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            setContentView(a.h.ala_red_packet_snatch_result_view);
            initView();
            this.eIB = new com.baidu.tieba.ala.f.e(getPageContext(), this.eID);
            this.eIB.ad(this.mRedPacketId, this.mLiveId, this.aQi);
            MessageManager.getInstance().registerListener(this.eIC);
            iM(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aQi = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eHd = findViewById(a.g.rp_result_root_bg);
        this.eHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_result_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.bAv = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aKJ = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aKJ.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aKJ.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aKJ.setIsRound(true);
        this.aKJ.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aKJ.setAutoChangeStyle(true);
        this.aKJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eIv = (TextView) findViewById(a.g.p_result_top10_desc);
        this.cBd = (TextView) findViewById(a.g.p_result_user_name);
        this.eIw = (TextView) findViewById(a.g.p_result_loot_amount);
        this.eHe = (LinearLayout) findViewById(a.g.rp_result_content);
        this.eIx = (TextView) findViewById(a.g.p_result_send_gift);
        this.eIy = (BdListView) findViewById(a.g.p_result_listview);
        this.eIx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bjN();
            }
        });
        this.eHe.setVisibility(8);
        this.eIx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjN() {
        s sVar = new s();
        sVar.aqT = -1;
        sVar.aqU = -1;
        sVar.aqW = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, sVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.eIA = dVar;
        this.eHe.setVisibility(0);
        this.eIx.setVisibility(0);
        if (!StringUtils.isNullObject(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.aKJ, dVar.portrait, true, false);
        }
        this.cBd.setText(dVar.userName);
        if (dVar.feN) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.fev));
            this.eIx.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eHe.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.eHe.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.eIx.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eHe.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.eHe.setLayoutParams(layoutParams2);
            str = string;
        }
        this.eIw.setText(str);
        P(dVar.feO);
    }

    private void P(ArrayList<d.a> arrayList) {
        this.eIz = new a(getPageContext().getPageActivity(), arrayList);
        this.eIy.setAdapter((ListAdapter) this.eIz);
        this.eIz.notifyDataSetChanged();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        iM(configuration.orientation == 2);
    }

    private void iM(boolean z) {
        if (z) {
            h.U(this.bAv);
            this.bAv.setScaleX(0.85f);
            this.bAv.setScaleY(0.85f);
            return;
        }
        h.V(this.bAv);
        this.bAv.setScaleX(1.0f);
        this.bAv.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eIB != null) {
            this.eIB.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eIC);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> eIF;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.eIF = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eIF != null) {
                return this.eIF.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oN */
        public d.a getItem(int i) {
            if (this.eIF != null) {
                return this.eIF.get(i);
            }
            return null;
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
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_loot_user_item, viewGroup, false);
                bVar2.eIG = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.eIG.setIsRound(true);
                bVar2.eIG.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.eIG.setAutoChangeStyle(true);
                bVar2.eIG.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.eIH = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.eII = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.eIG, item.portrait, true, false);
                }
                bVar.eIH.setText(item.userName);
                bVar.eII.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.feP)));
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private static class b {
        public HeadImageView eIG;
        public TextView eIH;
        public TextView eII;

        private b() {
        }
    }
}
