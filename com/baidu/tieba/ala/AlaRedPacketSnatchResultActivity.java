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
import com.baidu.live.data.v;
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
    private HeadImageView aQx;
    private String aWr;
    private FrameLayout bIi;
    private TextView dXU;
    private View eTA;
    private LinearLayout eTB;
    private TextView eUV;
    private TextView eUW;
    private TextView eUX;
    private BdListView eUY;
    private a eUZ;
    private com.baidu.tieba.ala.data.d eVa;
    private com.baidu.tieba.ala.f.e eVb;
    private CustomMessageListener eVc = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k eVd = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.f.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.f.k
        public void ax(int i, String str) {
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
            this.eVb = new com.baidu.tieba.ala.f.e(getPageContext(), this.eVd);
            this.eVb.ah(this.mRedPacketId, this.mLiveId, this.aWr);
            MessageManager.getInstance().registerListener(this.eVc);
            je(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aWr = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eTA = findViewById(a.g.rp_result_root_bg);
        this.eTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.bIi = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aQx = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aQx.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aQx.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aQx.setIsRound(true);
        this.aQx.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aQx.setAutoChangeStyle(true);
        this.aQx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUV = (TextView) findViewById(a.g.p_result_top10_desc);
        this.dXU = (TextView) findViewById(a.g.p_result_user_name);
        this.eUW = (TextView) findViewById(a.g.p_result_loot_amount);
        this.eTB = (LinearLayout) findViewById(a.g.rp_result_content);
        this.eUX = (TextView) findViewById(a.g.p_result_send_gift);
        this.eUY = (BdListView) findViewById(a.g.p_result_listview);
        this.eUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bph();
            }
        });
        this.eTB.setVisibility(8);
        this.eUX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bph() {
        v vVar = new v();
        vVar.avT = -1;
        vVar.avU = -1;
        vVar.avW = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, vVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.eVa = dVar;
        this.eTB.setVisibility(0);
        this.eUX.setVisibility(0);
        if (!StringUtils.isNullObject(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.aQx, dVar.portrait, true, false);
        }
        this.dXU.setText(dVar.userName);
        if (dVar.fss) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.fsa));
            this.eUX.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTB.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.eTB.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.eUX.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eTB.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.eTB.setLayoutParams(layoutParams2);
            str = string;
        }
        this.eUW.setText(str);
        P(dVar.fst);
    }

    private void P(ArrayList<d.a> arrayList) {
        this.eUZ = new a(getPageContext().getPageActivity(), arrayList);
        this.eUY.setAdapter((ListAdapter) this.eUZ);
        this.eUZ.notifyDataSetChanged();
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
        je(configuration.orientation == 2);
    }

    private void je(boolean z) {
        if (z) {
            h.T(this.bIi);
            this.bIi.setScaleX(0.85f);
            this.bIi.setScaleY(0.85f);
            return;
        }
        h.U(this.bIi);
        this.bIi.setScaleX(1.0f);
        this.bIi.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eVb != null) {
            this.eVb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eVc);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> eVf;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.eVf = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eVf != null) {
                return this.eVf.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: po */
        public d.a getItem(int i) {
            if (this.eVf != null) {
                return this.eVf.get(i);
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
                bVar2.aPy = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.aPy.setIsRound(true);
                bVar2.aPy.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.aPy.setAutoChangeStyle(true);
                bVar2.aPy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.eVg = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.eVh = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.aPy, item.portrait, true, false);
                }
                bVar.eVg.setText(item.userName);
                bVar.eVh.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.fsu)));
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private static class b {
        public HeadImageView aPy;
        public TextView eVg;
        public TextView eVh;

        private b() {
        }
    }
}
