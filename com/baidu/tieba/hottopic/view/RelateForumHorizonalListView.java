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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    private LinearLayout fLe;
    private final ArrayList<a> fLf;
    private View.OnClickListener fLg;
    private View fLh;
    private CustomMessageListener fLk;
    private CustomMessageListener fLl;
    private View.OnClickListener fLm;
    private View.OnClickListener fLn;
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
            if (this.fLl != null) {
                this.fLl.setTag(this.mTag);
            }
            if (this.fLk != null) {
                this.fLk.setTag(this.mTag);
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
        this.fLf = new ArrayList<>();
        this.mSkinType = 3;
        this.fLg = null;
        this.mTag = null;
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fLm = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bh.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (au.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cRE();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").al("obj_locate", 2).dY("obj_name", str).dY("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bn(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gu(str2, valueOf);
                }
            }
        };
        this.fLn = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (au.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cRE();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").al("obj_locate", 1).dY("obj_name", str).dY("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        ev(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fLf = new ArrayList<>();
        this.mSkinType = 3;
        this.fLg = null;
        this.mTag = null;
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fLm = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bh.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (au.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cRE();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").al("obj_locate", 2).dY("obj_name", str).dY("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bn(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gu(str2, valueOf);
                }
            }
        };
        this.fLn = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (au.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cRE();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").al("obj_locate", 1).dY("obj_name", str).dY("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        ev(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fLf = new ArrayList<>();
        this.mSkinType = 3;
        this.fLg = null;
        this.mTag = null;
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fLm = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!bh.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                final TextView textView = (TextView) view;
                if (au.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cRE();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").al("obj_locate", 2).dY("obj_name", str).dY("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bn(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gu(str2, valueOf);
                }
            }
        };
        this.fLn = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (au.isForumName(str2)) {
                    T orignalPage = RelateForumHorizonalListView.this.mTbPageContext.getOrignalPage();
                    String str3 = "";
                    if (!(orignalPage instanceof HotTopicActivity)) {
                        str = "";
                    } else {
                        String topicName = ((HotTopicActivity) orignalPage).getTopicName();
                        str3 = ((HotTopicActivity) orignalPage).cRE();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").al("obj_locate", 1).dY("obj_name", str).dY("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        ev(context);
    }

    private void ev(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.fLe = new LinearLayout(context);
        this.fLe.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fLe.setOrientation(0);
        addView(this.fLe);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext, boolean z) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            if (z) {
                list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            }
            int count = y.getCount(this.fLf);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    af.a aVar = (af.a) y.getItem(this.fLf, i);
                    if (aVar != null) {
                        this.fLe.removeView(aVar.getView());
                    }
                    this.fLf.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) y.getItem(list, i2);
                a aVar3 = (a) y.getItem(this.fLf, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.fLf.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.fLe.addView(createView);
                    }
                }
                if (i2 == count2 - 1 && z) {
                    a(this.fLf.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fLk);
            this.mTbPageContext.registerListener(this.fLl);
            if (getTag() != null) {
                this.fLk.setTag(getTag());
                this.fLl.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar) {
        if (aVar != null) {
            this.fLh = aVar.getView();
            aVar.khc.setVisibility(8);
            aVar.fLt.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.fLs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ap.setImageResource(aVar.fLs, R.drawable.icon_pic_more);
            ap.setViewTextColor(aVar.fLt, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(aVar.fLs, R.drawable.selector_load_more_bg);
            this.fLh.setClickable(true);
            this.fLh.setOnClickListener(this.fLg);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fLg = onClickListener;
    }

    public View getLastItemView() {
        return this.fLh;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.khc.setClickable(true);
            aVar2.khc.setOnClickListener(this.fLm);
            view.setClickable(true);
            view.setOnClickListener(this.fLn);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.extend_forum_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.fLs.setTag(aVar.forumAvatar);
            aVar2.fLs.startLoad(aVar.forumAvatar, 10, false);
            aVar2.fLt.setText(aW(aVar.forumName, 8));
            aVar2.fLt.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.khc.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.khc.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            d(aVar2.khc, aVar.isLiked);
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void d(TextView textView, boolean z) {
        textView.setTag(R.id.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            ap.setViewTextColor(textView, R.color.CAM_X0109, 1);
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
            Iterator<a> it = this.fLf.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fLh != null) {
                BarImageView barImageView = (BarImageView) this.fLh.findViewById(R.id.forum_avatar);
                ap.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ap.setImageResource(barImageView, R.drawable.icon_pic_more);
                ap.setViewTextColor((TextView) this.fLh.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.khc.getTag(R.id.forum_follow) != null && (aVar.khc.getTag(R.id.forum_follow) instanceof Boolean)) {
                d(aVar.khc, ((Boolean) aVar.khc.getTag(R.id.forum_follow)).booleanValue());
            }
            ap.setViewTextColor(aVar.fLt, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j, boolean z) {
        Iterator<a> it = this.fLf.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.fLt.getTag(R.id.tag_forum_id) != null) {
                TextView textView = next.khc;
                if (((Long) next.fLt.getTag(R.id.tag_forum_id)).longValue() == j) {
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
        public BarImageView fLs;
        public TextView fLt;
        public TextView khc;

        public a(View view) {
            super(view);
            this.fLs = null;
            this.fLt = null;
            this.khc = null;
            this.fLs = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fLs.setGifIconSupport(false);
            this.fLt = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.khc = (TextView) view.findViewById(R.id.forum_add_love);
        }
    }
}
