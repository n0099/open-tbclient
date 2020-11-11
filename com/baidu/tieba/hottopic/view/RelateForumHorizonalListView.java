package com.baidu.tieba.hottopic.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    private LinearLayout fDP;
    private final ArrayList<a> fDQ;
    private View.OnClickListener fDR;
    private View fDS;
    private CustomMessageListener fDV;
    private CustomMessageListener fDW;
    private View.OnClickListener fDX;
    private View.OnClickListener fDY;
    private String mFrom;
    private int mSkinType;
    private BdUniqueId mTag;
    private TbPageContext<?> mTbPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
        if (this.mTag != null) {
            if (this.fDW != null) {
                this.fDW.setTag(this.mTag);
            }
            if (this.fDV != null) {
                this.fDV.setTag(this.mTag);
            }
        }
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public RelateForumHorizonalListView(Context context) {
        super(context);
        this.fDQ = new ArrayList<>();
        this.mSkinType = 3;
        this.fDR = null;
        this.mTag = null;
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fDX = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bg.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (at.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cMI();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").al("obj_locate", 2).dR("obj_name", str).dR("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                v vVar = (v) obj;
                                vVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, vVar.isLike() == 1);
                            } else if (AntiHelper.bR(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bm(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gp(str2, valueOf);
                }
            }
        };
        this.fDY = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (at.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cMI();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").al("obj_locate", 1).dR("obj_name", str).dR("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        dQ(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDQ = new ArrayList<>();
        this.mSkinType = 3;
        this.fDR = null;
        this.mTag = null;
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fDX = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bg.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (at.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cMI();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").al("obj_locate", 2).dR("obj_name", str).dR("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                v vVar = (v) obj;
                                vVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, vVar.isLike() == 1);
                            } else if (AntiHelper.bR(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bm(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gp(str2, valueOf);
                }
            }
        };
        this.fDY = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (at.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cMI();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").al("obj_locate", 1).dR("obj_name", str).dR("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        dQ(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDQ = new ArrayList<>();
        this.mSkinType = 3;
        this.fDR = null;
        this.mTag = null;
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fDX = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bg.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (at.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cMI();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").al("obj_locate", 2).dR("obj_name", str).dR("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                v vVar = (v) obj;
                                vVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, vVar.isLike() == 1);
                            } else if (AntiHelper.bR(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bm(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gp(str2, valueOf);
                }
            }
        };
        this.fDY = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (at.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cMI();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").al("obj_locate", 1).dR("obj_name", str).dR("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        dQ(context);
    }

    private void dQ(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.fDP = new LinearLayout(context);
        this.fDP.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fDP.setOrientation(0);
        addView(this.fDP);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext, boolean z) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            if (z) {
                list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            }
            int count = y.getCount(this.fDQ);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    af.a aVar = (af.a) y.getItem(this.fDQ, i);
                    if (aVar != null) {
                        this.fDP.removeView(aVar.getView());
                    }
                    this.fDQ.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) y.getItem(list, i2);
                a aVar3 = (a) y.getItem(this.fDQ, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.fDQ.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.fDP.addView(createView);
                    }
                }
                if (i2 == count2 - 1 && z) {
                    a(this.fDQ.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fDV);
            this.mTbPageContext.registerListener(this.fDW);
            if (getTag() != null) {
                this.fDV.setTag(getTag());
                this.fDW.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar) {
        if (aVar != null) {
            this.fDS = aVar.getView();
            aVar.jSM.setVisibility(8);
            aVar.fEe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.fEd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ap.setImageResource(aVar.fEd, R.drawable.icon_pic_more);
            ap.setViewTextColor(aVar.fEe, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(aVar.fEd, R.drawable.selector_load_more_bg);
            this.fDS.setClickable(true);
            this.fDS.setOnClickListener(this.fDR);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fDR = onClickListener;
    }

    public View getLastItemView() {
        return this.fDS;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.jSM.setClickable(true);
            aVar2.jSM.setOnClickListener(this.fDX);
            view.setClickable(true);
            view.setOnClickListener(this.fDY);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.extend_forum_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.fEd.setTag(aVar.forumAvatar);
            aVar2.fEd.startLoad(aVar.forumAvatar, 10, false);
            aVar2.fEe.setText(aW(aVar.forumName, 8));
            aVar2.fEe.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.jSM.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.jSM.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            d(aVar2.jSM, aVar.isLiked);
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void d(TextView textView, boolean z) {
        textView.setTag(R.id.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            ap.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ap.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.fDQ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fDS != null) {
                BarImageView barImageView = (BarImageView) this.fDS.findViewById(R.id.forum_avatar);
                ap.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ap.setImageResource(barImageView, R.drawable.icon_pic_more);
                ap.setViewTextColor((TextView) this.fDS.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.jSM.getTag(R.id.forum_follow) != null && (aVar.jSM.getTag(R.id.forum_follow) instanceof Boolean)) {
                d(aVar.jSM, ((Boolean) aVar.jSM.getTag(R.id.forum_follow)).booleanValue());
            }
            ap.setViewTextColor(aVar.fEe, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j, boolean z) {
        Iterator<a> it = this.fDQ.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.fEe.getTag(R.id.tag_forum_id) != null) {
                TextView textView = next.jSM;
                if (((Long) next.fEe.getTag(R.id.tag_forum_id)).longValue() == j) {
                    d(textView, z);
                    return;
                }
            }
        }
    }

    private String aW(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            String substring = str.substring(0, i - 1);
            if (this.mTbPageContext != null) {
                substring = substring + this.mTbPageContext.getString(R.string.ellipsis);
            }
            return substring;
        }
        return str;
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public BarImageView fEd;
        public TextView fEe;
        public TextView jSM;

        public a(View view) {
            super(view);
            this.fEd = null;
            this.fEe = null;
            this.jSM = null;
            this.fEd = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fEd.setGifIconSupport(false);
            this.fEe = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.jSM = (TextView) view.findViewById(R.id.forum_add_love);
        }
    }
}
