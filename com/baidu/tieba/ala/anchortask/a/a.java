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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.b.a {
    private x alaLiveShowData;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a gHX;
    private com.baidu.tieba.ala.anchortask.b.c gHY;
    private String gHZ;
    private int gIc;
    private int gId;
    private d gIe;
    private AlaAnchorBannerViewPager gIf;
    private MyPagerAdapter gIh;
    private AlaAnchorViewPagerDot gIi;
    private int gIj;
    private Activity mActivity;
    private View mView;
    private Handler handler = new Handler();
    private Handler gIa = new Handler();
    private boolean gIb = false;
    private ArrayList<View> gIg = new ArrayList<>();
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bSa();
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gIk = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.gIe.gIw.setCanVisible(true);
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gHZ)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gHZ));
            }
            a.this.bSa();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private SlideRatioViewPager.OnPageChangeListener gIl = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.4
        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.gIi.tV(i);
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private HttpMessageListener gIm = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gHX != null) {
                a.this.gHY = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gHY;
                if (a.this.gHY != null && a.this.gHY.gIU != null) {
                    a.this.gHZ = a.this.gHY.gHZ;
                    a.this.bSb();
                    boolean a2 = a.this.gHX.a(a.this.gHY.gIU);
                    if (a.this.gIj == 1) {
                        a.this.gIe.gIw.setCanVisible(true);
                        if (a2) {
                            if (a.this.gIg.size() <= 1 && a.this.gHX != null) {
                                a.this.gIg.add(a.this.gHX.getView());
                                a.this.gIf.setAdapter(new MyPagerAdapter(a.this.context, a.this.gIg));
                                a.this.gIi.tW(a.this.gIg.size());
                            }
                        } else if (a.this.gIg.size() == 2) {
                            a.this.gIg.remove(1);
                            a.this.gIf.setAdapter(new MyPagerAdapter(a.this.context, a.this.gIg));
                            a.this.gIi.tW(a.this.gIg.size());
                        }
                    } else if (!a2) {
                        a.this.gIg.clear();
                        a.this.mView.setVisibility(8);
                    } else if (a.this.gHX != null) {
                        a.this.gIg.clear();
                        a.this.gIg.add(a.this.gHX.getView());
                        a.this.gIf.setAdapter(new MyPagerAdapter(a.this.context, a.this.gIg));
                        a.this.gIi.tW(a.this.gIg.size());
                    }
                    if (a.this.gHY.gIU.gII == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };
    private Runnable gIn = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = a.this.gIf.getCurrentItem() + 1;
                    if (a.this.gIg.size() > 0) {
                        a.this.gIf.setCurrentItem(currentItem % a.this.gIg.size());
                        a.this.gIi.tV(currentItem % a.this.gIg.size());
                    }
                }
            });
            a.this.gIa.postDelayed(a.this.gIn, 10000L);
        }
    };
    CustomMessageListener gIo = new CustomMessageListener(2913284) { // from class: com.baidu.tieba.ala.anchortask.a.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gIf != null) {
                a.this.gIf.setVisibility(8);
            }
        }
    };
    CustomMessageListener gIp = new CustomMessageListener(2913283) { // from class: com.baidu.tieba.ala.anchortask.a.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gIf != null) {
                a.this.gIf.setVisibility(0);
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gHX = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gIe = new d(context);
        this.gHX.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gHX.getView() != null) {
            this.gHX.getView().setOnClickListener(this.onClickListener);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Activity activity, int i) {
        boolean z;
        cc ccVar = com.baidu.live.af.a.OJ().bxp.aMY;
        this.mActivity = activity;
        if (ccVar != null && this.gIe != null) {
            this.gIe.tU(i);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                z = ccVar.aNQ == 1;
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                z = ccVar.aNR == 1;
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                z = ccVar.aNS == 1;
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = ccVar.aNT == 1;
            } else {
                z = false;
            }
            if (z) {
                if (this.gHX != null) {
                    this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_viewpager, (ViewGroup) null);
                    this.gIi = (AlaAnchorViewPagerDot) this.mView.findViewById(a.f.anchor_task_dot);
                    this.mView.setId(a.f.anthor_task_viewpager_id);
                    this.gIf = (AlaAnchorBannerViewPager) this.mView.findViewById(a.f.anchor_view_pager);
                    this.gIf.requestDisallowInterceptTouchEvent(true);
                    this.gIj = i;
                    if (i == 1) {
                        this.gIg.add(this.gIe.gIw.getView());
                        this.gIe.gIw.setCanVisible(false);
                        this.gIa.postDelayed(this.gIk, 10000L);
                    }
                    this.gHX.U(this.gIg);
                    this.gIh = new MyPagerAdapter(this.context, this.gIg);
                    this.gIf.setAdapter(this.gIh);
                    this.gIi.tW(this.gIg.size());
                    viewGroup.addView(this.mView, layoutParams);
                    this.gIa.postDelayed(this.gIn, 10000L);
                    this.gIf.addOnPageChangeListener(this.gIl);
                }
                this.handler.postDelayed(this.runnable, 10000L);
                MessageManager.getInstance().registerListener(this.gIo);
                MessageManager.getInstance().registerListener(this.gIp);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(x xVar) {
        this.alaLiveShowData = xVar;
        this.gIe.a(xVar);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gIm);
    }

    public void bSa() {
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
    public void bSb() {
        if (this.gHY != null && this.gHY.gIU != null) {
            if (!this.gIb) {
                this.gIb = true;
                this.gIc = this.gHY.gIU.gIG;
                this.gId = this.gHY.gIU.gIH;
            }
            int i = this.gHY.gIU.gII;
            int i2 = this.gHY.gIU.gIJ;
            int i3 = this.gHY.gIU.gIK;
            String str = null;
            if (this.gIc == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gIc == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gIc == 1 && i == 1) {
                if (i2 > this.gId) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gId) {
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
            this.gIc = i;
            this.gId = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.gHX != null) {
            this.gHX.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.gHX != null) {
            this.gHX.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        this.gIa.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gIm);
        MessageManager.getInstance().unRegisterListener(this.gIo);
        MessageManager.getInstance().unRegisterListener(this.gIp);
        if (this.gHX != null) {
            this.gHX.onDestroy();
        }
        if (this.gIe != null) {
            this.gIe.onDestory();
        }
    }
}
