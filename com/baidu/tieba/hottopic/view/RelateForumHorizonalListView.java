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
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    private LinearLayout ePK;
    private final ArrayList<a> ePL;
    private View.OnClickListener ePM;
    private View ePN;
    private CustomMessageListener ePQ;
    private CustomMessageListener ePR;
    private View.OnClickListener ePS;
    private View.OnClickListener ePT;
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
            if (this.ePR != null) {
                this.ePR.setTag(this.mTag);
            }
            if (this.ePQ != null) {
                this.ePQ.setTag(this.mTag);
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
        this.ePL = new ArrayList<>();
        this.mSkinType = 3;
        this.ePM = null;
        this.mTag = null;
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ePS = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bf.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (as.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).coQ();
                        str = topicName;
                    }
                    TiebaStatic.log(new ap("c10815").ah("obj_locate", 2).dn("obj_name", str).dn("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                u uVar = (u) obj;
                                uVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, uVar.isLike() == 1);
                            } else if (AntiHelper.bB(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.aW(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.fz(str2, valueOf);
                }
            }
        };
        this.ePT = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (as.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).coQ();
                        str = topicName;
                    }
                    TiebaStatic.log(new ap("c10815").ah("obj_locate", 1).dn("obj_name", str).dn("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ePL = new ArrayList<>();
        this.mSkinType = 3;
        this.ePM = null;
        this.mTag = null;
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ePS = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bf.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (as.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).coQ();
                        str = topicName;
                    }
                    TiebaStatic.log(new ap("c10815").ah("obj_locate", 2).dn("obj_name", str).dn("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                u uVar = (u) obj;
                                uVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, uVar.isLike() == 1);
                            } else if (AntiHelper.bB(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.aW(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.fz(str2, valueOf);
                }
            }
        };
        this.ePT = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (as.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).coQ();
                        str = topicName;
                    }
                    TiebaStatic.log(new ap("c10815").ah("obj_locate", 1).dn("obj_name", str).dn("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ePL = new ArrayList<>();
        this.mSkinType = 3;
        this.ePM = null;
        this.mTag = null;
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ePS = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bf.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (as.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).coQ();
                        str = topicName;
                    }
                    TiebaStatic.log(new ap("c10815").ah("obj_locate", 2).dn("obj_name", str).dn("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                u uVar = (u) obj;
                                uVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, uVar.isLike() == 1);
                            } else if (AntiHelper.bB(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.aW(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.fz(str2, valueOf);
                }
            }
        };
        this.ePT = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (as.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).coQ();
                        str = topicName;
                    }
                    TiebaStatic.log(new ap("c10815").ah("obj_locate", 1).dn("obj_name", str).dn("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.ePK = new LinearLayout(context);
        this.ePK.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.ePK.setOrientation(0);
        addView(this.ePK);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext, boolean z) {
        if (x.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            if (z) {
                list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            }
            int count = x.getCount(this.ePL);
            int count2 = x.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    ad.a aVar = (ad.a) x.getItem(this.ePL, i);
                    if (aVar != null) {
                        this.ePK.removeView(aVar.getView());
                    }
                    this.ePL.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) x.getItem(list, i2);
                a aVar3 = (a) x.getItem(this.ePL, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.ePL.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.ePK.addView(createView);
                    }
                }
                if (i2 == count2 - 1 && z) {
                    a(this.ePL.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.ePQ);
            this.mTbPageContext.registerListener(this.ePR);
            if (getTag() != null) {
                this.ePQ.setTag(getTag());
                this.ePR.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar) {
        if (aVar != null) {
            this.ePN = aVar.getView();
            aVar.iNG.setVisibility(8);
            aVar.ePZ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.ePY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ao.setImageResource(aVar.ePY, R.drawable.icon_pic_more);
            ao.setViewTextColor(aVar.ePZ, R.color.cp_cont_b, 1);
            ao.setBackgroundResource(aVar.ePY, R.drawable.selector_load_more_bg);
            this.ePN.setClickable(true);
            this.ePN.setOnClickListener(this.ePM);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.ePM = onClickListener;
    }

    public View getLastItemView() {
        return this.ePN;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.iNG.setClickable(true);
            aVar2.iNG.setOnClickListener(this.ePS);
            view.setClickable(true);
            view.setOnClickListener(this.ePT);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.extend_forum_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.ePY.setTag(aVar.forumAvatar);
            aVar2.ePY.startLoad(aVar.forumAvatar, 10, false);
            aVar2.ePZ.setText(aP(aVar.forumName, 8));
            aVar2.ePZ.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.iNG.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.iNG.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            d(aVar2.iNG, aVar.isLiked);
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void d(TextView textView, boolean z) {
        textView.setTag(R.id.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            ao.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ao.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        textView.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.ePL.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.ePN != null) {
                BarImageView barImageView = (BarImageView) this.ePN.findViewById(R.id.forum_avatar);
                ao.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ao.setImageResource(barImageView, R.drawable.icon_pic_more);
                ao.setViewTextColor((TextView) this.ePN.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.iNG.getTag(R.id.forum_follow) != null && (aVar.iNG.getTag(R.id.forum_follow) instanceof Boolean)) {
                d(aVar.iNG, ((Boolean) aVar.iNG.getTag(R.id.forum_follow)).booleanValue());
            }
            ao.setViewTextColor(aVar.ePZ, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, boolean z) {
        Iterator<a> it = this.ePL.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.ePZ.getTag(R.id.tag_forum_id) != null) {
                TextView textView = next.iNG;
                if (((Long) next.ePZ.getTag(R.id.tag_forum_id)).longValue() == j) {
                    d(textView, z);
                    return;
                }
            }
        }
    }

    private String aP(String str, int i) {
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

    /* loaded from: classes15.dex */
    public static class a extends ad.a {
        public BarImageView ePY;
        public TextView ePZ;
        public TextView iNG;

        public a(View view) {
            super(view);
            this.ePY = null;
            this.ePZ = null;
            this.iNG = null;
            this.ePY = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.ePY.setGifIconSupport(false);
            this.ePZ = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.iNG = (TextView) view.findViewById(R.id.forum_add_love);
        }
    }
}
