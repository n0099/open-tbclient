package com.baidu.tieba.ala.anchortask.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ca;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorViewPagerDot;
import com.baidu.tieba.ala.anchortask.viewpager.MyPagerAdapter;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.b.a {
    private w alaLiveShowData;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a gAT;
    private com.baidu.tieba.ala.anchortask.b.c gAU;
    private String gAV;
    private int gAY;
    private int gAZ;
    private d gBa;
    private AlaAnchorBannerViewPager gBb;
    private MyPagerAdapter gBd;
    private AlaAnchorViewPagerDot gBe;
    private int gBf;
    private Activity mActivity;
    private View mView;
    private Handler handler = new Handler();
    private Handler gAW = new Handler();
    private boolean gAX = false;
    private ArrayList<View> gBc = new ArrayList<>();
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bTm();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private Runnable gBg = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.gBa.gBq.setCanVisible(true);
        }
    };
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gAV)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gAV));
            }
            a.this.bTm();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private SlideRatioViewPager.OnPageChangeListener gBh = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.4
        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.gBe.vq(i);
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private HttpMessageListener gBi = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gAT != null) {
                a.this.gAU = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gAU;
                if (a.this.gAU != null && a.this.gAU.gBO != null) {
                    a.this.gAV = a.this.gAU.gAV;
                    a.this.bTn();
                    boolean a2 = a.this.gAT.a(a.this.gAU.gBO);
                    if (a.this.gBf == 1) {
                        a.this.gBa.gBq.setCanVisible(true);
                        if (a2) {
                            if (a.this.gBc.size() <= 1 && a.this.gAT != null) {
                                a.this.gBc.add(a.this.gAT.getView());
                                a.this.gBb.setAdapter(new MyPagerAdapter(a.this.context, a.this.gBc));
                                a.this.gBe.vr(a.this.gBc.size());
                            }
                        } else if (a.this.gBc.size() == 2) {
                            a.this.gBc.remove(1);
                            a.this.gBb.setAdapter(new MyPagerAdapter(a.this.context, a.this.gBc));
                            a.this.gBe.vr(a.this.gBc.size());
                        }
                    } else if (!a2) {
                        a.this.gBc.clear();
                        a.this.mView.setVisibility(8);
                    } else if (a.this.gAT != null) {
                        a.this.gBc.clear();
                        a.this.gBc.add(a.this.gAT.getView());
                        a.this.gBb.setAdapter(new MyPagerAdapter(a.this.context, a.this.gBc));
                        a.this.gBe.vr(a.this.gBc.size());
                    }
                    if (a.this.gAU.gBO.gBC == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };
    private Runnable gBj = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = a.this.gBb.getCurrentItem() + 1;
                    if (a.this.gBc.size() > 0) {
                        a.this.gBb.setCurrentItem(currentItem % a.this.gBc.size());
                        a.this.gBe.vq(currentItem % a.this.gBc.size());
                    }
                }
            });
            a.this.gAW.postDelayed(a.this.gBj, 10000L);
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gAT = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gBa = new d(context);
        this.gAT.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gAT.getView() != null) {
            this.gAT.getView().setOnClickListener(this.foP);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Activity activity, int i) {
        boolean z;
        ca caVar = com.baidu.live.ae.a.RB().bxq.aQW;
        this.mActivity = activity;
        if (caVar != null && this.gBa != null) {
            this.gBa.vp(i);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                z = caVar.aRP == 1;
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                z = caVar.aRQ == 1;
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                z = caVar.aRR == 1;
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = caVar.aRS == 1;
            } else {
                z = false;
            }
            if (z) {
                if (this.gAT != null) {
                    this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_viewpager, (ViewGroup) null);
                    this.gBe = (AlaAnchorViewPagerDot) this.mView.findViewById(a.f.anchor_task_dot);
                    this.mView.setId(a.f.anthor_task_viewpager_id);
                    this.gBb = (AlaAnchorBannerViewPager) this.mView.findViewById(a.f.anchor_view_pager);
                    this.gBb.requestDisallowInterceptTouchEvent(true);
                    this.gBf = i;
                    if (i == 1) {
                        this.gBc.add(this.gBa.gBq.getView());
                        this.gBa.gBq.setCanVisible(false);
                        this.gAW.postDelayed(this.gBg, 10000L);
                    }
                    this.gAT.Z(this.gBc);
                    this.gBd = new MyPagerAdapter(this.context, this.gBc);
                    this.gBb.setAdapter(this.gBd);
                    this.gBe.vr(this.gBc.size());
                    viewGroup.addView(this.mView, layoutParams);
                    this.gAW.postDelayed(this.gBj, 10000L);
                    this.gBb.addOnPageChangeListener(this.gBh);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(w wVar) {
        this.alaLiveShowData = wVar;
        this.gBa.a(wVar);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gBi);
    }

    public void bTm() {
        if (this.alaLiveShowData != null) {
            long j = this.alaLiveShowData.mLiveInfo.live_id;
            long j2 = this.alaLiveShowData.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.setAnchorId(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTn() {
        if (this.gAU != null && this.gAU.gBO != null) {
            if (!this.gAX) {
                this.gAX = true;
                this.gAY = this.gAU.gBO.gBA;
                this.gAZ = this.gAU.gBO.gBB;
            }
            int i = this.gAU.gBO.gBC;
            int i2 = this.gAU.gBO.gBD;
            int i3 = this.gAU.gBO.gBE;
            String str = null;
            if (this.gAY == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gAY == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gAY == 1 && i == 1) {
                if (i2 > this.gAZ) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gAZ) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_reduce), Integer.valueOf(i3)) + "%";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("text", str);
                    jSONObject.put("content_type", "custom_anchor_identity_update");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913143, jSONObject.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.gAY = i;
            this.gAZ = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.gAT != null) {
            this.gAT.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.gAT != null) {
            this.gAT.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        this.gAW.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gBi);
        if (this.gAT != null) {
            this.gAT.onDestroy();
        }
        if (this.gBa != null) {
            this.gBa.onDestory();
        }
    }
}
