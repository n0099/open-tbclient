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
    private final CustomMessageListener auR;
    private f bha;
    private PbListView blb;
    private boolean cXM;
    private View cYV;
    private CustomMessageListener cYq;
    private BdTypeListView dAe;
    private View.OnClickListener dAz;
    private l dDD;
    private com.baidu.tieba.homepage.framework.b dDE;
    private d dDF;
    private a dDG;
    private com.baidu.tieba.homepage.personalize.model.e dDH;
    private long dDI;
    private QuizEntranceFloatingView dDJ;
    private boolean dDK;
    private NEGFeedBackView.a dDL;
    private d.a dDM;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dDF != null) {
            this.dDF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dDG != null) {
            this.dDG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dAe != null) {
            this.dAe.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dDD != null) {
            this.dDD.setPageUniqueId(bdUniqueId);
        }
        if (this.dDF != null) {
            this.dDF.j(bdUniqueId);
        }
        if (this.dDH != null) {
            this.dDH.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.auR != null) {
            this.auR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.auR);
        }
        if (this.dDG != null) {
            this.dDG.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.dDI = 0L;
        this.mSkinType = 3;
        this.cXM = false;
        this.dDK = false;
        this.dDL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.dDM = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aN(int i, int i2) {
                if (PersonalizePageView.this.dDE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Ou();
                    return;
                }
                boolean axe = PersonalizePageView.this.axe();
                PersonalizePageView.this.Qn();
                if (axe) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dDE.aM(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dDE != null) {
                    PersonalizePageView.this.dDE.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.Ou();
                if (i != 1) {
                    PersonalizePageView.this.dAe.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dAe.setVisibility(0);
                PersonalizePageView.this.Ou();
                PersonalizePageView.this.Qn();
                FloatInfo axV = PersonalizePageView.this.dDF.axV();
                if (axV != null) {
                    PersonalizePageView.this.dDJ.setData(axV);
                    PersonalizePageView.this.dDJ.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axV.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dDJ.setVisibility(8);
            }
        };
        this.auR = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.axI();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dAz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Po();
            }
        };
        this.cYq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cXM = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDI = 0L;
        this.mSkinType = 3;
        this.cXM = false;
        this.dDK = false;
        this.dDL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.dDM = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aN(int i, int i2) {
                if (PersonalizePageView.this.dDE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Ou();
                    return;
                }
                boolean axe = PersonalizePageView.this.axe();
                PersonalizePageView.this.Qn();
                if (axe) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dDE.aM(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dDE != null) {
                    PersonalizePageView.this.dDE.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.Ou();
                if (i != 1) {
                    PersonalizePageView.this.dAe.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dAe.setVisibility(0);
                PersonalizePageView.this.Ou();
                PersonalizePageView.this.Qn();
                FloatInfo axV = PersonalizePageView.this.dDF.axV();
                if (axV != null) {
                    PersonalizePageView.this.dDJ.setData(axV);
                    PersonalizePageView.this.dDJ.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axV.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dDJ.setVisibility(8);
            }
        };
        this.auR = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.axI();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dAz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Po();
            }
        };
        this.cYq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cXM = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDI = 0L;
        this.mSkinType = 3;
        this.cXM = false;
        this.dDK = false;
        this.dDL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.dDM = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aN(int i2, int i22) {
                if (PersonalizePageView.this.dDE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Ou();
                    return;
                }
                boolean axe = PersonalizePageView.this.axe();
                PersonalizePageView.this.Qn();
                if (axe) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dDE.aM(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i2, int i22, int i3) {
                if (PersonalizePageView.this.dDE != null) {
                    PersonalizePageView.this.dDE.B(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.Ou();
                if (i2 != 1) {
                    PersonalizePageView.this.dAe.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dAe.setVisibility(0);
                PersonalizePageView.this.Ou();
                PersonalizePageView.this.Qn();
                FloatInfo axV = PersonalizePageView.this.dDF.axV();
                if (axV != null) {
                    PersonalizePageView.this.dDJ.setData(axV);
                    PersonalizePageView.this.dDJ.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axV.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dDJ.setVisibility(8);
            }
        };
        this.auR = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.axI();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dAz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Po();
            }
        };
        this.cYq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cXM = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dAe = new BdTypeListView(context);
        this.dAe.setDividerHeight(0);
        this.dAe.setSelector(17170445);
        this.blb = new PbListView(context);
        this.blb.getView();
        this.blb.du(d.C0126d.cp_bg_line_e);
        this.blb.wO();
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.dt(d.C0126d.cp_cont_e);
        this.blb.setHeight(com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        this.blb.setOnClickListener(this.dAz);
        this.dAe.setNextPage(this.blb);
        com.baidu.adp.base.e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        this.mPullView = new com.baidu.tbadk.core.view.f(this.pageContext);
        this.dAe.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.cYV = BdListViewHelper.a(context, this.dAe, BdListViewHelper.HeadType.DEFAULT);
        this.dDH = new com.baidu.tieba.homepage.personalize.model.e();
        this.dDD = new l(context, this.dAe);
        this.dDD.b(this.dDH);
        this.dDF = new d(this.pageContext, this.dAe, this.dDD);
        this.dDG = new a(this.pageContext);
        addView(this.dAe);
        this.dDJ = new QuizEntranceFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.e(context, d.e.tbds182), com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds238);
        addView(this.dDJ, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cYq);
        this.dDJ.setCallback(new QuizEntranceFloatingView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.a
            public void axJ() {
                TiebaStatic.log(new al("c12913").r("obj_locate", 2));
                com.baidu.tbadk.browser.a.M(PersonalizePageView.this.getContext(), TbConfig.NANI_CAMPUS_SQUARE);
            }

            @Override // com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.a
            public void axK() {
                TiebaStatic.log(new al("c12913").r("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", PersonalizePageView.this.dDF.axV() == null ? 0L : PersonalizePageView.this.dDF.axV().start_time.longValue());
                PersonalizePageView.this.dDJ.setVisibility(8);
            }
        });
        this.dDJ.setVisibility(8);
    }

    public void asV() {
        this.dDD.a(this.dDL);
        this.dDF.a(this.dDM);
        this.dDG.a(this);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                com.baidu.tieba.a.d.MH().hX("page_recommend");
                PersonalizePageView.this.dDF.update();
            }
        });
        this.mPullView.a(new e.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.e.c
            public void aP(boolean z) {
                if (PersonalizePageView.this.dDF != null) {
                    if (PersonalizePageView.this.dDF.aqc() != null) {
                        PersonalizePageView.this.dDF.aqc().aza();
                    }
                    PersonalizePageView.this.dDF.gv(false);
                }
            }
        });
        this.dAe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.Po();
            }
        });
        this.dAe.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.dDI >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.dDF.aO(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tbadk.core.view.e.a
            public void c(View view2, boolean z) {
                if (PersonalizePageView.this.dDF != null) {
                    PersonalizePageView.this.dDF.gv(true);
                    PersonalizePageView.this.dDF.axO();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
            }
        });
        this.dAe.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view2) {
                if (view2 != null) {
                    if (PersonalizePageView.this.dDF != null && PersonalizePageView.this.dDF.aqc() != null) {
                        PersonalizePageView.this.dDF.aqc().aM(view2);
                    }
                    if (view2.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view2.getTag()).afY().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dDE = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.blb != null) {
            this.blb.wS();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dDF.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dDF != null) {
            this.dDF.gt(!z);
        }
        this.dDK = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dDK;
    }

    public void e(Long l) {
        this.dDF.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cYV != null && this.cYV.getLayoutParams() != null) {
            if (this.dDF != null) {
                this.dDF.setHeaderViewHeight(i);
            }
            if (this.dDG != null) {
                this.dDG.setHeaderViewHeight(i);
            }
            this.cYV.getLayoutParams().height = i;
            this.cYV.setLayoutParams(this.cYV.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dDF != null) {
            this.dDF.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dDF != null) {
            this.dDF.showFloatingView();
        }
    }

    public void axH() {
        if (this.dDF != null) {
            this.dDF.axH();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bha != null) {
                this.bha.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dv(i);
            }
            if (this.blb != null) {
                this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                this.blb.dv(i);
            }
            this.dDD.onChangeSkinType(i);
            ak.j(this, d.C0126d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void Y(String str, int i) {
        if (this.blb != null) {
            this.blb.wS();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dDF.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view2, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (PersonalizePageView.this.dDF != null) {
                        PersonalizePageView.this.dDF.update();
                    }
                }
            });
        }
        this.refreshView.fa(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view2, z);
        this.refreshView.Fu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ou() {
        if (this.bha != null) {
            this.bha.P(this);
            this.bha = null;
            this.dAe.setNextPage(this.blb);
        }
        if (this.dDE != null) {
            this.dDE.axr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axe() {
        if (this.refreshView != null) {
            return this.refreshView.Fm();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bha == null) {
            if (i < 0) {
                this.bha = new f(getContext());
            } else {
                this.bha = new f(getContext(), i);
            }
            this.bha.onChangeSkinType();
        }
        this.bha.d(this, z);
        this.dAe.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dDF != null) {
            this.dDF.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dDF != null) {
            this.dDF.fx(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dDF != null) {
            this.dDF.go(z);
        }
    }

    public void axa() {
        if (this.dDF != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dDF.update();
        }
    }

    public void reload() {
        if (this.dAe != null) {
            showFloatingView();
            this.dAe.setSelection(0);
            if (this.dAe.isRefreshDone()) {
                if (this.dDF != null && this.dDF.aqc() != null) {
                    this.dDF.aqc().aza();
                    this.dDF.gv(false);
                }
                this.dAe.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cYq);
        this.dDF.onDestroy();
        this.dDD.a((NEGFeedBackView.a) null);
        this.dDF.a((d.a) null);
        this.mPullView.a((e.b) null);
        this.mPullView.a((e.c) null);
        this.dAe.setOnSrollToBottomListener(null);
        this.mPullView.a((e.a) null);
        this.mPullView.release();
        if (this.bha != null) {
            this.bha.release();
        }
        this.dAe.setRecyclerListener(null);
        if (this.dDG != null) {
            this.dDG.onDestroy();
        }
    }

    public void onPause() {
        this.dDF.onPause();
    }

    public void onResume() {
        this.dDF.onResume();
        if (this.cXM) {
            reload();
            this.cXM = false;
        }
    }

    public void axI() {
        if (this.dDD != null) {
            this.dDD.notifyDataSetChanged();
        }
    }

    public void axg() {
        if (this.dDF != null) {
            this.dDF.fx(true);
        }
        v.afy().cB(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void axF() {
        this.dDF.axU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        com.baidu.tieba.homepage.framework.a.axq().i(System.currentTimeMillis(), 1);
        if (this.blb != null && !this.blb.wX()) {
            this.blb.wR();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dDF.Po();
    }
}
