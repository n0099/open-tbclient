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
import com.baidu.live.data.cc;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorViewPagerDot;
import com.baidu.tieba.ala.anchortask.viewpager.MyPagerAdapter;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.b.a {
    private x alaLiveShowData;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a gMD;
    private com.baidu.tieba.ala.anchortask.b.c gME;
    private String gMF;
    private int gMI;
    private int gMJ;
    private d gMK;
    private AlaAnchorBannerViewPager gML;
    private MyPagerAdapter gMN;
    private AlaAnchorViewPagerDot gMO;
    private int gMP;
    private Activity mActivity;
    private View mView;
    private Handler handler = new Handler();
    private Handler gMG = new Handler();
    private boolean gMH = false;
    private ArrayList<View> gMM = new ArrayList<>();
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bVR();
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gMQ = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.gMK.gNc.setCanVisible(true);
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gMF)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gMF));
            }
            a.this.bVR();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private SlideRatioViewPager.OnPageChangeListener gMR = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.4
        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.gMO.vB(i);
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private HttpMessageListener gMS = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gMD != null) {
                a.this.gME = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gME;
                if (a.this.gME != null && a.this.gME.gNA != null) {
                    a.this.gMF = a.this.gME.gMF;
                    a.this.bVS();
                    boolean a2 = a.this.gMD.a(a.this.gME.gNA);
                    if (a.this.gMP == 1) {
                        a.this.gMK.gNc.setCanVisible(true);
                        if (a2) {
                            if (a.this.gMM.size() <= 1 && a.this.gMD != null) {
                                a.this.gMM.add(a.this.gMD.getView());
                                a.this.gML.setAdapter(new MyPagerAdapter(a.this.context, a.this.gMM));
                                a.this.gMO.vC(a.this.gMM.size());
                            }
                        } else if (a.this.gMM.size() == 2) {
                            a.this.gMM.remove(1);
                            a.this.gML.setAdapter(new MyPagerAdapter(a.this.context, a.this.gMM));
                            a.this.gMO.vC(a.this.gMM.size());
                        }
                    } else if (!a2) {
                        a.this.gMM.clear();
                        a.this.mView.setVisibility(8);
                    } else if (a.this.gMD != null) {
                        a.this.gMM.clear();
                        a.this.gMM.add(a.this.gMD.getView());
                        a.this.gML.setAdapter(new MyPagerAdapter(a.this.context, a.this.gMM));
                        a.this.gMO.vC(a.this.gMM.size());
                    }
                    if (a.this.gME.gNA.gNo == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };
    private Runnable gMT = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = a.this.gML.getCurrentItem() + 1;
                    if (a.this.gMM.size() > 0) {
                        a.this.gML.setCurrentItem(currentItem % a.this.gMM.size());
                        a.this.gMO.vB(currentItem % a.this.gMM.size());
                    }
                }
            });
            a.this.gMG.postDelayed(a.this.gMT, 10000L);
        }
    };
    CustomMessageListener gMU = new CustomMessageListener(2913284) { // from class: com.baidu.tieba.ala.anchortask.a.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gML != null) {
                a.this.gML.setVisibility(8);
            }
        }
    };
    CustomMessageListener gMV = new CustomMessageListener(2913283) { // from class: com.baidu.tieba.ala.anchortask.a.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gML != null) {
                a.this.gML.setVisibility(0);
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gMD = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gMK = new d(context);
        this.gMD.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gMD.getView() != null) {
            this.gMD.getView().setOnClickListener(this.onClickListener);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Activity activity, int i) {
        boolean z;
        cc ccVar = com.baidu.live.af.a.SE().bCb.aRL;
        this.mActivity = activity;
        if (ccVar != null && this.gMK != null) {
            this.gMK.vA(i);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                z = ccVar.aSD == 1;
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                z = ccVar.aSE == 1;
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                z = ccVar.aSF == 1;
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = ccVar.aSG == 1;
            } else {
                z = false;
            }
            if (z) {
                if (this.gMD != null) {
                    this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_viewpager, (ViewGroup) null);
                    this.gMO = (AlaAnchorViewPagerDot) this.mView.findViewById(a.f.anchor_task_dot);
                    this.mView.setId(a.f.anthor_task_viewpager_id);
                    this.gML = (AlaAnchorBannerViewPager) this.mView.findViewById(a.f.anchor_view_pager);
                    this.gML.requestDisallowInterceptTouchEvent(true);
                    this.gMP = i;
                    if (i == 1) {
                        this.gMM.add(this.gMK.gNc.getView());
                        this.gMK.gNc.setCanVisible(false);
                        this.gMG.postDelayed(this.gMQ, 10000L);
                    }
                    this.gMD.Z(this.gMM);
                    this.gMN = new MyPagerAdapter(this.context, this.gMM);
                    this.gML.setAdapter(this.gMN);
                    this.gMO.vC(this.gMM.size());
                    viewGroup.addView(this.mView, layoutParams);
                    this.gMG.postDelayed(this.gMT, 10000L);
                    this.gML.addOnPageChangeListener(this.gMR);
                }
                this.handler.postDelayed(this.runnable, 10000L);
                MessageManager.getInstance().registerListener(this.gMU);
                MessageManager.getInstance().registerListener(this.gMV);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(x xVar) {
        this.alaLiveShowData = xVar;
        this.gMK.a(xVar);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gMS);
    }

    public void bVR() {
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
    public void bVS() {
        if (this.gME != null && this.gME.gNA != null) {
            if (!this.gMH) {
                this.gMH = true;
                this.gMI = this.gME.gNA.gNm;
                this.gMJ = this.gME.gNA.gNn;
            }
            int i = this.gME.gNA.gNo;
            int i2 = this.gME.gNA.gNp;
            int i3 = this.gME.gNA.gNq;
            String str = null;
            if (this.gMI == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gMI == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gMI == 1 && i == 1) {
                if (i2 > this.gMJ) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gMJ) {
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
            this.gMI = i;
            this.gMJ = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.gMD != null) {
            this.gMD.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.gMD != null) {
            this.gMD.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        this.gMG.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gMS);
        MessageManager.getInstance().unRegisterListener(this.gMU);
        MessageManager.getInstance().unRegisterListener(this.gMV);
        if (this.gMD != null) {
            this.gMD.onDestroy();
        }
        if (this.gMK != null) {
            this.gMK.onDestory();
        }
    }
}
