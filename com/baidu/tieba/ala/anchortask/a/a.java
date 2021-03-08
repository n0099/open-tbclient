package com.baidu.tieba.ala.anchortask.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ab;
import com.baidu.live.data.cj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.tieba.ala.anchortask.b.c;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorViewPagerDot;
import com.baidu.tieba.ala.anchortask.viewpager.MyPagerAdapter;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.b.a {
    private ab alaLiveShowData;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a gME;
    private c gMF;
    private String gMG;
    private int gMJ;
    private int gMK;
    private b gML;
    private AlaAnchorBannerViewPager gMM;
    private MyPagerAdapter gMO;
    private AlaAnchorViewPagerDot gMP;
    private int gMQ;
    private Activity mActivity;
    private View mView;
    private Handler handler = new Handler();
    private Handler gMH = new Handler();
    private boolean gMI = false;
    private ArrayList<View> gMN = new ArrayList<>();
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bSQ();
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gMR = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.gML.gMZ.setCanVisible(true);
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gMG)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gMG));
            }
            a.this.bSQ();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private SlideRatioViewPager.OnPageChangeListener gMS = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.4
        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.gMP.ud(i);
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private HttpMessageListener gMT = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gME != null) {
                a.this.gMF = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gMF;
                if (a.this.gMF != null && a.this.gMF.gNx != null) {
                    a.this.gMG = a.this.gMF.gMG;
                    a.this.bSR();
                    boolean a2 = a.this.gME.a(a.this.gMF.gNx);
                    if (a.this.gMQ == 1) {
                        a.this.gML.gMZ.setCanVisible(true);
                        if (a2) {
                            if (a.this.gMN.size() <= 1 && a.this.gME != null) {
                                a.this.gMN.add(a.this.gME.getView());
                                a.this.gMM.setAdapter(new MyPagerAdapter(a.this.context, a.this.gMN));
                                a.this.gMP.ue(a.this.gMN.size());
                            }
                        } else if (a.this.gMN.size() == 2) {
                            a.this.gMN.remove(1);
                            a.this.gMM.setAdapter(new MyPagerAdapter(a.this.context, a.this.gMN));
                            a.this.gMP.ue(a.this.gMN.size());
                        }
                    } else if (!a2) {
                        a.this.gMN.clear();
                        a.this.mView.setVisibility(8);
                    } else if (a.this.gME != null) {
                        a.this.gMN.clear();
                        a.this.gMN.add(a.this.gME.getView());
                        a.this.gMM.setAdapter(new MyPagerAdapter(a.this.context, a.this.gMN));
                        a.this.gMP.ue(a.this.gMN.size());
                    }
                    if (a.this.gMF.gNx.gNl == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };
    private Runnable gMU = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = a.this.gMM.getCurrentItem() + 1;
                    if (a.this.gMN.size() > 0) {
                        a.this.gMM.setCurrentItem(currentItem % a.this.gMN.size());
                        a.this.gMP.ud(currentItem % a.this.gMN.size());
                    }
                }
            });
            a.this.gMH.postDelayed(a.this.gMU, 10000L);
        }
    };
    CustomMessageListener gMV = new CustomMessageListener(2913284) { // from class: com.baidu.tieba.ala.anchortask.a.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gMM != null) {
                a.this.gMM.setVisibility(8);
            }
        }
    };
    CustomMessageListener gMW = new CustomMessageListener(2913283) { // from class: com.baidu.tieba.ala.anchortask.a.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gMM != null) {
                a.this.gMM.setVisibility(0);
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gME = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gML = new b(context);
        this.gME.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gME.getView() != null) {
            this.gME.getView().setOnClickListener(this.onClickListener);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Activity activity, int i) {
        boolean z;
        cj cjVar = com.baidu.live.ae.a.Qm().bCs.aRw;
        this.mActivity = activity;
        if (cjVar != null && this.gML != null) {
            this.gML.uc(i);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                z = cjVar.aSr == 1;
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                z = cjVar.aSs == 1;
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                z = cjVar.aSt == 1;
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = cjVar.aSu == 1;
            } else {
                z = false;
            }
            if (z) {
                if (this.gME != null) {
                    this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_viewpager, (ViewGroup) null);
                    this.gMP = (AlaAnchorViewPagerDot) this.mView.findViewById(a.f.anchor_task_dot);
                    this.mView.setId(a.f.anthor_task_viewpager_id);
                    this.gMM = (AlaAnchorBannerViewPager) this.mView.findViewById(a.f.anchor_view_pager);
                    this.gMM.requestDisallowInterceptTouchEvent(true);
                    this.gMQ = i;
                    if (i == 1) {
                        this.gMN.add(this.gML.gMZ.getView());
                        this.gML.gMZ.setCanVisible(false);
                        this.gMH.postDelayed(this.gMR, 10000L);
                    }
                    this.gME.T(this.gMN);
                    this.gMO = new MyPagerAdapter(this.context, this.gMN);
                    this.gMM.setAdapter(this.gMO);
                    this.gMP.ue(this.gMN.size());
                    viewGroup.addView(this.mView, layoutParams);
                    this.gMH.postDelayed(this.gMU, 10000L);
                    this.gMM.addOnPageChangeListener(this.gMS);
                }
                this.handler.postDelayed(this.runnable, 10000L);
                MessageManager.getInstance().registerListener(this.gMV);
                MessageManager.getInstance().registerListener(this.gMW);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ab abVar) {
        this.alaLiveShowData = abVar;
        this.gML.a(abVar);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gMT);
    }

    public void bSQ() {
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
    public void bSR() {
        if (this.gMF != null && this.gMF.gNx != null) {
            if (!this.gMI) {
                this.gMI = true;
                this.gMJ = this.gMF.gNx.gNj;
                this.gMK = this.gMF.gNx.gNk;
            }
            int i = this.gMF.gNx.gNl;
            int i2 = this.gMF.gNx.gNm;
            int i3 = this.gMF.gNx.gNn;
            String str = null;
            if (this.gMJ == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gMJ == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gMJ == 1 && i == 1) {
                if (i2 > this.gMK) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gMK) {
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
            this.gMJ = i;
            this.gMK = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.gME != null) {
            this.gME.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.gME != null) {
            this.gME.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        this.gMH.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gMT);
        MessageManager.getInstance().unRegisterListener(this.gMV);
        MessageManager.getInstance().unRegisterListener(this.gMW);
        if (this.gME != null) {
            this.gME.onDestroy();
        }
        if (this.gML != null) {
            this.gML.onDestory();
        }
    }
}
