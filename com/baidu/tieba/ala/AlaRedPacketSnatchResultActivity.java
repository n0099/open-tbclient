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
    private HeadImageView aKD;
    private String aQc;
    private FrameLayout bAq;
    private TextView cAX;
    private View eGY;
    private LinearLayout eGZ;
    private TextView eIq;
    private TextView eIr;
    private TextView eIs;
    private BdListView eIt;
    private a eIu;
    private com.baidu.tieba.ala.data.d eIv;
    private com.baidu.tieba.ala.f.e eIw;
    private CustomMessageListener eIx = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k eIy = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.f.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.f.k
        public void as(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
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
            this.eIw = new com.baidu.tieba.ala.f.e(getPageContext(), this.eIy);
            this.eIw.ad(this.mRedPacketId, this.mLiveId, this.aQc);
            MessageManager.getInstance().registerListener(this.eIx);
            iM(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aQc = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eGY = findViewById(a.g.rp_result_root_bg);
        this.eGY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.bAq = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aKD = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aKD.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aKD.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aKD.setIsRound(true);
        this.aKD.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aKD.setAutoChangeStyle(true);
        this.aKD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eIq = (TextView) findViewById(a.g.p_result_top10_desc);
        this.cAX = (TextView) findViewById(a.g.p_result_user_name);
        this.eIr = (TextView) findViewById(a.g.p_result_loot_amount);
        this.eGZ = (LinearLayout) findViewById(a.g.rp_result_content);
        this.eIs = (TextView) findViewById(a.g.p_result_send_gift);
        this.eIt = (BdListView) findViewById(a.g.p_result_listview);
        this.eIs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bjP();
            }
        });
        this.eGZ.setVisibility(8);
        this.eIs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjP() {
        s sVar = new s();
        sVar.aqN = -1;
        sVar.aqO = -1;
        sVar.aqQ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, sVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.eIv = dVar;
        this.eGZ.setVisibility(0);
        this.eIs.setVisibility(0);
        if (!StringUtils.isNullObject(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.aKD, dVar.portrait, true, false);
        }
        this.cAX.setText(dVar.userName);
        if (dVar.feI) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.feq));
            this.eIs.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eGZ.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.eGZ.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.eIs.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eGZ.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.eGZ.setLayoutParams(layoutParams2);
            str = string;
        }
        this.eIr.setText(str);
        P(dVar.feJ);
    }

    private void P(ArrayList<d.a> arrayList) {
        this.eIu = new a(getPageContext().getPageActivity(), arrayList);
        this.eIt.setAdapter((ListAdapter) this.eIu);
        this.eIu.notifyDataSetChanged();
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
            h.U(this.bAq);
            this.bAq.setScaleX(0.85f);
            this.bAq.setScaleY(0.85f);
            return;
        }
        h.V(this.bAq);
        this.bAq.setScaleX(1.0f);
        this.bAq.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eIw != null) {
            this.eIw.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eIx);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> eIA;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.eIA = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eIA != null) {
                return this.eIA.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oN */
        public d.a getItem(int i) {
            if (this.eIA != null) {
                return this.eIA.get(i);
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
                bVar2.eIB = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.eIB.setIsRound(true);
                bVar2.eIB.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.eIB.setAutoChangeStyle(true);
                bVar2.eIB.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.eIC = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.eID = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.eIB, item.portrait, true, false);
                }
                bVar.eIC.setText(item.userName);
                bVar.eID.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.feK)));
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private static class b {
        public HeadImageView eIB;
        public TextView eIC;
        public TextView eID;

        private b() {
        }
    }
}
