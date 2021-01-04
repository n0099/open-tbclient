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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes8.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    private LinearLayout fUK;
    private final ArrayList<ItemViewHolder> fUL;
    private View.OnClickListener fUM;
    private View fUN;
    private CustomMessageListener fUQ;
    private CustomMessageListener fUR;
    private View.OnClickListener fUS;
    private View.OnClickListener fUT;
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
            if (this.fUR != null) {
                this.fUR.setTag(this.mTag);
            }
            if (this.fUQ != null) {
                this.fUQ.setTag(this.mTag);
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
        this.fUL = new ArrayList<>();
        this.mSkinType = 3;
        this.fUM = null;
        this.mTag = null;
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.h(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.h(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fUS = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
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
                        str3 = ((HotTopicActivity) orignalPage).cUK();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").an("obj_locate", 2).dX("obj_name", str).dX("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bs(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gr(str2, valueOf);
                }
            }
        };
        this.fUT = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
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
                        str3 = ((HotTopicActivity) orignalPage).cUK();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").an("obj_locate", 1).dX("obj_name", str).dX("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        eO(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fUL = new ArrayList<>();
        this.mSkinType = 3;
        this.fUM = null;
        this.mTag = null;
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.h(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.h(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fUS = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
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
                        str3 = ((HotTopicActivity) orignalPage).cUK();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").an("obj_locate", 2).dX("obj_name", str).dX("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bs(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gr(str2, valueOf);
                }
            }
        };
        this.fUT = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
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
                        str3 = ((HotTopicActivity) orignalPage).cUK();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").an("obj_locate", 1).dX("obj_name", str).dX("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        eO(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fUL = new ArrayList<>();
        this.mSkinType = 3;
        this.fUM = null;
        this.mTag = null;
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.h(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.h(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fUS = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
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
                        str3 = ((HotTopicActivity) orignalPage).cUK();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").an("obj_locate", 2).dX("obj_name", str).dX("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.d(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bs(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gr(str2, valueOf);
                }
            }
        };
        this.fUT = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
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
                        str3 = ((HotTopicActivity) orignalPage).cUK();
                        str = topicName;
                    }
                    TiebaStatic.log(new aq("c10815").an("obj_locate", 1).dX("obj_name", str).dX("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        eO(context);
    }

    private void eO(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.fUK = new LinearLayout(context);
        this.fUK.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fUK.setOrientation(0);
        addView(this.fUK);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext, boolean z) {
        if (x.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            if (z) {
                list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            }
            int count = x.getCount(this.fUL);
            int count2 = x.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) x.getItem(this.fUL, i);
                    if (viewHolder != null) {
                        this.fUK.removeView(viewHolder.getView());
                    }
                    this.fUL.remove(viewHolder);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar = (com.baidu.tbadk.widget.horizonalScrollListView.a) x.getItem(list, i2);
                ItemViewHolder itemViewHolder = (ItemViewHolder) x.getItem(this.fUL, i2);
                if (itemViewHolder != null) {
                    b(itemViewHolder.getView(), aVar);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        ItemViewHolder itemViewHolder2 = new ItemViewHolder(createView);
                        this.fUL.add(itemViewHolder2);
                        b(itemViewHolder2.getView(), aVar);
                        this.fUK.addView(createView);
                    }
                }
                if (i2 == count2 - 1 && z) {
                    a(this.fUL.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fUQ);
            this.mTbPageContext.registerListener(this.fUR);
            if (getTag() != null) {
                this.fUQ.setTag(getTag());
                this.fUR.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(ItemViewHolder itemViewHolder) {
        if (itemViewHolder != null) {
            this.fUN = itemViewHolder.getView();
            itemViewHolder.kuo.setVisibility(8);
            itemViewHolder.fUZ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            itemViewHolder.fUY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ao.setImageResource(itemViewHolder.fUY, R.drawable.icon_pic_more);
            ao.setViewTextColor(itemViewHolder.fUZ, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(itemViewHolder.fUY, R.drawable.selector_load_more_bg);
            this.fUN.setClickable(true);
            this.fUN.setOnClickListener(this.fUM);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fUM = onClickListener;
    }

    public View getLastItemView() {
        return this.fUN;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.kuo.setClickable(true);
            itemViewHolder.kuo.setOnClickListener(this.fUS);
            view.setClickable(true);
            view.setOnClickListener(this.fUT);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.extend_forum_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.fUY.setTag(aVar.forumAvatar);
            itemViewHolder.fUY.startLoad(aVar.forumAvatar, 10, false);
            itemViewHolder.fUZ.setText(be(aVar.forumName, 8));
            itemViewHolder.fUZ.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.kuo.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.kuo.setTag(R.id.tag_forum_name, aVar.forumName);
            itemViewHolder.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            d(itemViewHolder.kuo, aVar.isLiked);
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void d(TextView textView, boolean z) {
        textView.setTag(R.id.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            ao.setViewTextColor(textView, R.color.CAM_X0109, 1);
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
            Iterator<ItemViewHolder> it = this.fUL.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fUN != null) {
                BarImageView barImageView = (BarImageView) this.fUN.findViewById(R.id.forum_avatar);
                ao.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ao.setImageResource(barImageView, R.drawable.icon_pic_more);
                ao.setViewTextColor((TextView) this.fUN.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(ItemViewHolder itemViewHolder, int i) {
        if (itemViewHolder != null && itemViewHolder.getView() != null) {
            if (itemViewHolder.kuo.getTag(R.id.forum_follow) != null && (itemViewHolder.kuo.getTag(R.id.forum_follow) instanceof Boolean)) {
                d(itemViewHolder.kuo, ((Boolean) itemViewHolder.kuo.getTag(R.id.forum_follow)).booleanValue());
            }
            ao.setViewTextColor(itemViewHolder.fUZ, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, boolean z) {
        Iterator<ItemViewHolder> it = this.fUL.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null && next.getView() != null && next.fUZ.getTag(R.id.tag_forum_id) != null) {
                TextView textView = next.kuo;
                if (((Long) next.fUZ.getTag(R.id.tag_forum_id)).longValue() == j) {
                    d(textView, z);
                    return;
                }
            }
        }
    }

    private String be(String str, int i) {
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

    /* loaded from: classes8.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public BarImageView fUY;
        public TextView fUZ;
        public TextView kuo;

        public ItemViewHolder(View view) {
            super(view);
            this.fUY = null;
            this.fUZ = null;
            this.kuo = null;
            this.fUY = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fUY.setGifIconSupport(false);
            this.fUZ = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.kuo = (TextView) view.findViewById(R.id.forum_add_love);
        }
    }
}
