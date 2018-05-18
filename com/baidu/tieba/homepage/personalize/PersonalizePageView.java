package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.d;
import com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes2.dex */
public class PersonalizePageView extends FrameLayout {
    private final CustomMessageListener auS;
    private f bhf;
    private PbListView blq;
    private boolean cYT;
    private CustomMessageListener cZx;
    private View.OnClickListener dBG;
    private BdTypeListView dBl;
    private l dEJ;
    private com.baidu.tieba.homepage.framework.b dEK;
    private d dEL;
    private a dEM;
    private com.baidu.tieba.homepage.personalize.model.e dEN;
    private long dEO;
    private QuizEntranceFloatingView dEP;
    private boolean dEQ;
    private NEGFeedBackView.a dER;
    private d.a dES;
    private View dac;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dEL != null) {
            this.dEL.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dEM != null) {
            this.dEM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dBl != null) {
            this.dBl.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dEJ != null) {
            this.dEJ.setPageUniqueId(bdUniqueId);
        }
        if (this.dEL != null) {
            this.dEL.j(bdUniqueId);
        }
        if (this.dEN != null) {
            this.dEN.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.auS != null) {
            this.auS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.auS);
        }
        if (this.dEM != null) {
            this.dEM.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.dEO = 0L;
        this.mSkinType = 3;
        this.cYT = false;
        this.dEQ = false;
        this.dER = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new al("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new al("c11989").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new al("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dES = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aN(int i, int i2) {
                if (PersonalizePageView.this.dEK == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Os();
                    return;
                }
                boolean axd = PersonalizePageView.this.axd();
                PersonalizePageView.this.Qk();
                if (axd) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dEK.aM(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dEK != null) {
                    PersonalizePageView.this.dEK.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.Os();
                if (i != 1) {
                    PersonalizePageView.this.dBl.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dBl.setVisibility(0);
                PersonalizePageView.this.Os();
                PersonalizePageView.this.Qk();
                FloatInfo axT = PersonalizePageView.this.dEL.axT();
                if (axT != null) {
                    PersonalizePageView.this.dEP.setData(axT);
                    PersonalizePageView.this.dEP.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axT.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dEP.setVisibility(8);
            }
        };
        this.auS = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.axG();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dBG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Pl();
            }
        };
        this.cZx = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cYT = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEO = 0L;
        this.mSkinType = 3;
        this.cYT = false;
        this.dEQ = false;
        this.dER = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new al("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new al("c11989").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new al("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dES = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aN(int i, int i2) {
                if (PersonalizePageView.this.dEK == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Os();
                    return;
                }
                boolean axd = PersonalizePageView.this.axd();
                PersonalizePageView.this.Qk();
                if (axd) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dEK.aM(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dEK != null) {
                    PersonalizePageView.this.dEK.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.Os();
                if (i != 1) {
                    PersonalizePageView.this.dBl.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dBl.setVisibility(0);
                PersonalizePageView.this.Os();
                PersonalizePageView.this.Qk();
                FloatInfo axT = PersonalizePageView.this.dEL.axT();
                if (axT != null) {
                    PersonalizePageView.this.dEP.setData(axT);
                    PersonalizePageView.this.dEP.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axT.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dEP.setVisibility(8);
            }
        };
        this.auS = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.axG();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dBG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Pl();
            }
        };
        this.cZx = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cYT = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEO = 0L;
        this.mSkinType = 3;
        this.cYT = false;
        this.dEQ = false;
        this.dER = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new al("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new al("c11989").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        sb.append(arrayList.get(i2) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new al("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dES = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aN(int i2, int i22) {
                if (PersonalizePageView.this.dEK == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Os();
                    return;
                }
                boolean axd = PersonalizePageView.this.axd();
                PersonalizePageView.this.Qk();
                if (axd) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dEK.aM(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i2, int i22, int i3) {
                if (PersonalizePageView.this.dEK != null) {
                    PersonalizePageView.this.dEK.B(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.Os();
                if (i2 != 1) {
                    PersonalizePageView.this.dBl.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dBl.setVisibility(0);
                PersonalizePageView.this.Os();
                PersonalizePageView.this.Qk();
                FloatInfo axT = PersonalizePageView.this.dEL.axT();
                if (axT != null) {
                    PersonalizePageView.this.dEP.setData(axT);
                    PersonalizePageView.this.dEP.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axT.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dEP.setVisibility(8);
            }
        };
        this.auS = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.axG();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dBG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Pl();
            }
        };
        this.cZx = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cYT = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dBl = new BdTypeListView(context);
        this.dBl.setDividerHeight(0);
        this.dBl.setSelector(17170445);
        this.blq = new PbListView(context);
        this.blq.getView();
        this.blq.dv(d.C0126d.cp_bg_line_e);
        this.blq.wN();
        this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blq.setTextSize(d.e.tbfontsize33);
        this.blq.du(d.C0126d.cp_cont_e);
        this.blq.setHeight(com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        this.blq.setOnClickListener(this.dBG);
        this.dBl.setNextPage(this.blq);
        com.baidu.adp.base.e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        this.mPullView = new com.baidu.tbadk.core.view.f(this.pageContext);
        this.dBl.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.dac = BdListViewHelper.a(context, this.dBl, BdListViewHelper.HeadType.DEFAULT);
        this.dEN = new com.baidu.tieba.homepage.personalize.model.e();
        this.dEJ = new l(context, this.dBl);
        this.dEJ.b(this.dEN);
        this.dEL = new d(this.pageContext, this.dBl, this.dEJ);
        this.dEM = new a(this.pageContext);
        addView(this.dBl);
        this.dEP = new QuizEntranceFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.e(context, d.e.tbds182), com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds238);
        addView(this.dEP, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cZx);
        this.dEP.setCallback(new QuizEntranceFloatingView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.a
            public void axH() {
                TiebaStatic.log(new al("c12913").r("obj_locate", 2));
                com.baidu.tbadk.browser.a.M(PersonalizePageView.this.getContext(), TbConfig.NANI_CAMPUS_SQUARE);
            }

            @Override // com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.a
            public void axI() {
                TiebaStatic.log(new al("c12913").r("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", PersonalizePageView.this.dEL.axT() == null ? 0L : PersonalizePageView.this.dEL.axT().start_time.longValue());
                PersonalizePageView.this.dEP.setVisibility(8);
            }
        });
        this.dEP.setVisibility(8);
    }

    public void asU() {
        this.dEJ.a(this.dER);
        this.dEL.a(this.dES);
        this.dEM.a(this);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                com.baidu.tieba.a.d.MF().hY("page_recommend");
                PersonalizePageView.this.dEL.update();
            }
        });
        this.mPullView.a(new e.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.e.c
            public void aP(boolean z) {
                if (PersonalizePageView.this.dEL != null) {
                    if (PersonalizePageView.this.dEL.aqb() != null) {
                        PersonalizePageView.this.dEL.aqb().ayY();
                    }
                    PersonalizePageView.this.dEL.gw(false);
                }
            }
        });
        this.dBl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.Pl();
            }
        });
        this.dBl.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.dEO >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.dEL.aO(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tbadk.core.view.e.a
            public void c(View view2, boolean z) {
                if (PersonalizePageView.this.dEL != null) {
                    PersonalizePageView.this.dEL.gw(true);
                    PersonalizePageView.this.dEL.axM();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
            }
        });
        this.dBl.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view2) {
                if (view2 != null) {
                    if (PersonalizePageView.this.dEL != null && PersonalizePageView.this.dEL.aqb() != null) {
                        PersonalizePageView.this.dEL.aqb().aM(view2);
                    }
                    if (view2.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view2.getTag()).afY().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dEK = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.blq != null) {
            this.blq.wR();
            this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dEL.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dEL != null) {
            this.dEL.gu(!z);
        }
        this.dEQ = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dEQ;
    }

    public void e(Long l) {
        this.dEL.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dac != null && this.dac.getLayoutParams() != null) {
            if (this.dEL != null) {
                this.dEL.setHeaderViewHeight(i);
            }
            if (this.dEM != null) {
                this.dEM.setHeaderViewHeight(i);
            }
            this.dac.getLayoutParams().height = i;
            this.dac.setLayoutParams(this.dac.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dEL != null) {
            this.dEL.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dEL != null) {
            this.dEL.showFloatingView();
        }
    }

    public void axF() {
        if (this.dEL != null) {
            this.dEL.axF();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bhf != null) {
                this.bhf.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dw(i);
            }
            if (this.blq != null) {
                this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                this.blq.dw(i);
            }
            this.dEJ.onChangeSkinType(i);
            ak.j(this, d.C0126d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void Y(String str, int i) {
        if (this.blq != null) {
            this.blq.wR();
            this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dEL.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view2, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (PersonalizePageView.this.dEL != null) {
                        PersonalizePageView.this.dEL.update();
                    }
                }
            });
        }
        this.refreshView.fb(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view2, z);
        this.refreshView.Fs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qk() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        if (this.bhf != null) {
            this.bhf.P(this);
            this.bhf = null;
            this.dBl.setNextPage(this.blq);
        }
        if (this.dEK != null) {
            this.dEK.axq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axd() {
        if (this.refreshView != null) {
            return this.refreshView.Fk();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhf == null) {
            if (i < 0) {
                this.bhf = new f(getContext());
            } else {
                this.bhf = new f(getContext(), i);
            }
            this.bhf.onChangeSkinType();
        }
        this.bhf.d(this, z);
        this.dBl.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dEL != null) {
            this.dEL.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dEL != null) {
            this.dEL.fy(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dEL != null) {
            this.dEL.gp(z);
        }
    }

    public void awZ() {
        if (this.dEL != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dEL.update();
        }
    }

    public void reload() {
        if (this.dBl != null) {
            showFloatingView();
            this.dBl.setSelection(0);
            if (this.dBl.isRefreshDone()) {
                if (this.dEL != null && this.dEL.aqb() != null) {
                    this.dEL.aqb().ayY();
                    this.dEL.gw(false);
                }
                this.dBl.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cZx);
        this.dEL.onDestroy();
        this.dEJ.a((NEGFeedBackView.a) null);
        this.dEL.a((d.a) null);
        this.mPullView.a((e.b) null);
        this.mPullView.a((e.c) null);
        this.dBl.setOnSrollToBottomListener(null);
        this.mPullView.a((e.a) null);
        this.mPullView.release();
        if (this.bhf != null) {
            this.bhf.release();
        }
        this.dBl.setRecyclerListener(null);
        if (this.dEM != null) {
            this.dEM.onDestroy();
        }
    }

    public void onPause() {
        this.dEL.onPause();
    }

    public void onResume() {
        this.dEL.onResume();
        if (this.cYT) {
            reload();
            this.cYT = false;
        }
    }

    public void axG() {
        if (this.dEJ != null) {
            this.dEJ.notifyDataSetChanged();
        }
    }

    public void axf() {
        if (this.dEL != null) {
            this.dEL.fy(true);
        }
        v.afy().cB(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void axD() {
        this.dEL.axS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pl() {
        com.baidu.tieba.homepage.framework.a.axp().h(System.currentTimeMillis(), 1);
        if (this.blq != null && !this.blq.wW()) {
            this.blq.wQ();
            this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dEL.Pl();
    }
}
