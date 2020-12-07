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
    private com.baidu.tieba.ala.anchortask.c.a gAR;
    private com.baidu.tieba.ala.anchortask.b.c gAS;
    private String gAT;
    private int gAW;
    private int gAX;
    private d gAY;
    private AlaAnchorBannerViewPager gAZ;
    private MyPagerAdapter gBb;
    private AlaAnchorViewPagerDot gBc;
    private int gBd;
    private Activity mActivity;
    private View mView;
    private Handler handler = new Handler();
    private Handler gAU = new Handler();
    private boolean gAV = false;
    private ArrayList<View> gBa = new ArrayList<>();
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bTl();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private Runnable gBe = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.gAY.gBo.setCanVisible(true);
        }
    };
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gAT)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gAT));
            }
            a.this.bTl();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private SlideRatioViewPager.OnPageChangeListener gBf = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.4
        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.gBc.vq(i);
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private HttpMessageListener gBg = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gAR != null) {
                a.this.gAS = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gAS;
                if (a.this.gAS != null && a.this.gAS.gBM != null) {
                    a.this.gAT = a.this.gAS.gAT;
                    a.this.bTm();
                    boolean a2 = a.this.gAR.a(a.this.gAS.gBM);
                    if (a.this.gBd == 1) {
                        a.this.gAY.gBo.setCanVisible(true);
                        if (a2) {
                            if (a.this.gBa.size() <= 1 && a.this.gAR != null) {
                                a.this.gBa.add(a.this.gAR.getView());
                                a.this.gAZ.setAdapter(new MyPagerAdapter(a.this.context, a.this.gBa));
                                a.this.gBc.vr(a.this.gBa.size());
                            }
                        } else if (a.this.gBa.size() == 2) {
                            a.this.gBa.remove(1);
                            a.this.gAZ.setAdapter(new MyPagerAdapter(a.this.context, a.this.gBa));
                            a.this.gBc.vr(a.this.gBa.size());
                        }
                    } else if (!a2) {
                        a.this.gBa.clear();
                        a.this.mView.setVisibility(8);
                    } else if (a.this.gAR != null) {
                        a.this.gBa.clear();
                        a.this.gBa.add(a.this.gAR.getView());
                        a.this.gAZ.setAdapter(new MyPagerAdapter(a.this.context, a.this.gBa));
                        a.this.gBc.vr(a.this.gBa.size());
                    }
                    if (a.this.gAS.gBM.gBA == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };
    private Runnable gBh = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = a.this.gAZ.getCurrentItem() + 1;
                    if (a.this.gBa.size() > 0) {
                        a.this.gAZ.setCurrentItem(currentItem % a.this.gBa.size());
                        a.this.gBc.vq(currentItem % a.this.gBa.size());
                    }
                }
            });
            a.this.gAU.postDelayed(a.this.gBh, 10000L);
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gAR = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gAY = new d(context);
        this.gAR.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gAR.getView() != null) {
            this.gAR.getView().setOnClickListener(this.foP);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Activity activity, int i) {
        boolean z;
        ca caVar = com.baidu.live.ae.a.RB().bxq.aQW;
        this.mActivity = activity;
        if (caVar != null && this.gAY != null) {
            this.gAY.vp(i);
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
                if (this.gAR != null) {
                    this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_viewpager, (ViewGroup) null);
                    this.gBc = (AlaAnchorViewPagerDot) this.mView.findViewById(a.f.anchor_task_dot);
                    this.mView.setId(a.f.anthor_task_viewpager_id);
                    this.gAZ = (AlaAnchorBannerViewPager) this.mView.findViewById(a.f.anchor_view_pager);
                    this.gAZ.requestDisallowInterceptTouchEvent(true);
                    this.gBd = i;
                    if (i == 1) {
                        this.gBa.add(this.gAY.gBo.getView());
                        this.gAY.gBo.setCanVisible(false);
                        this.gAU.postDelayed(this.gBe, 10000L);
                    }
                    this.gAR.Z(this.gBa);
                    this.gBb = new MyPagerAdapter(this.context, this.gBa);
                    this.gAZ.setAdapter(this.gBb);
                    this.gBc.vr(this.gBa.size());
                    viewGroup.addView(this.mView, layoutParams);
                    this.gAU.postDelayed(this.gBh, 10000L);
                    this.gAZ.addOnPageChangeListener(this.gBf);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(w wVar) {
        this.alaLiveShowData = wVar;
        this.gAY.a(wVar);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gBg);
    }

    public void bTl() {
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
    public void bTm() {
        if (this.gAS != null && this.gAS.gBM != null) {
            if (!this.gAV) {
                this.gAV = true;
                this.gAW = this.gAS.gBM.gBy;
                this.gAX = this.gAS.gBM.gBz;
            }
            int i = this.gAS.gBM.gBA;
            int i2 = this.gAS.gBM.gBB;
            int i3 = this.gAS.gBM.gBC;
            String str = null;
            if (this.gAW == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gAW == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gAW == 1 && i == 1) {
                if (i2 > this.gAX) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gAX) {
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
            this.gAW = i;
            this.gAX = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.gAR != null) {
            this.gAR.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.gAR != null) {
            this.gAR.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        this.gAU.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gBg);
        if (this.gAR != null) {
            this.gAR.onDestroy();
        }
        if (this.gAY != null) {
            this.gAY.onDestory();
        }
    }
}
