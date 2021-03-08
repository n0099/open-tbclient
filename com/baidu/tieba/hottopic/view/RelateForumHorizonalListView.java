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
/* loaded from: classes7.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    private LinearLayout fTQ;
    private final ArrayList<ItemViewHolder> fTR;
    private View.OnClickListener fTS;
    private View fTT;
    private CustomMessageListener fTW;
    private CustomMessageListener fTX;
    private View.OnClickListener fTY;
    private View.OnClickListener fTZ;
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
            if (this.fTX != null) {
                this.fTX.setTag(this.mTag);
            }
            if (this.fTW != null) {
                this.fTW.setTag(this.mTag);
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
        this.fTR = new ArrayList<>();
        this.mSkinType = 3;
        this.fTS = null;
        this.mTag = null;
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fTY = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
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
                        str3 = ((HotTopicActivity) orignalPage).cTg();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").aq("obj_locate", 2).dR("obj_name", str).dR("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.e(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bq(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gy(str2, valueOf);
                }
            }
        };
        this.fTZ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
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
                        str3 = ((HotTopicActivity) orignalPage).cTg();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").aq("obj_locate", 1).dR("obj_name", str).dR("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fTR = new ArrayList<>();
        this.mSkinType = 3;
        this.fTS = null;
        this.mTag = null;
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fTY = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
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
                        str3 = ((HotTopicActivity) orignalPage).cTg();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").aq("obj_locate", 2).dR("obj_name", str).dR("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.e(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bq(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gy(str2, valueOf);
                }
            }
        };
        this.fTZ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
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
                        str3 = ((HotTopicActivity) orignalPage).cTg();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").aq("obj_locate", 1).dR("obj_name", str).dR("topic_id", str3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fTR = new ArrayList<>();
        this.mSkinType = 3;
        this.fTS = null;
        this.mTag = null;
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    RelateForumHorizonalListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fTY = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3
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
                        str3 = ((HotTopicActivity) orignalPage).cTg();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").aq("obj_locate", 2).dR("obj_name", str).dR("topic_id", str3));
                    final LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.mTbPageContext);
                    likeModel.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.3.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                w wVar = (w) obj;
                                wVar.setLike(1);
                                RelateForumHorizonalListView.this.e(textView, wVar.isLike() == 1);
                            } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                AntiHelper.bq(RelateForumHorizonalListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                            } else {
                                RelateForumHorizonalListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                            }
                        }
                    });
                    likeModel.gy(str2, valueOf);
                }
            }
        };
        this.fTZ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.RelateForumHorizonalListView.4
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
                        str3 = ((HotTopicActivity) orignalPage).cTg();
                        str = topicName;
                    }
                    TiebaStatic.log(new ar("c10815").aq("obj_locate", 1).dR("obj_name", str).dR("topic_id", str3));
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
        this.fTQ = new LinearLayout(context);
        this.fTQ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fTQ.setOrientation(0);
        addView(this.fTQ);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext, boolean z) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            if (z) {
                list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            }
            int count = y.getCount(this.fTR);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) y.getItem(this.fTR, i);
                    if (viewHolder != null) {
                        this.fTQ.removeView(viewHolder.getView());
                    }
                    this.fTR.remove(viewHolder);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar = (com.baidu.tbadk.widget.horizonalScrollListView.a) y.getItem(list, i2);
                ItemViewHolder itemViewHolder = (ItemViewHolder) y.getItem(this.fTR, i2);
                if (itemViewHolder != null) {
                    b(itemViewHolder.getView(), aVar);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        ItemViewHolder itemViewHolder2 = new ItemViewHolder(createView);
                        this.fTR.add(itemViewHolder2);
                        b(itemViewHolder2.getView(), aVar);
                        this.fTQ.addView(createView);
                    }
                }
                if (i2 == count2 - 1 && z) {
                    a(this.fTR.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fTW);
            this.mTbPageContext.registerListener(this.fTX);
            if (getTag() != null) {
                this.fTW.setTag(getTag());
                this.fTX.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(ItemViewHolder itemViewHolder) {
        if (itemViewHolder != null) {
            this.fTT = itemViewHolder.getView();
            itemViewHolder.kAg.setVisibility(8);
            itemViewHolder.fUf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            itemViewHolder.fUe.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ap.setImageResource(itemViewHolder.fUe, R.drawable.icon_pic_more);
            ap.setViewTextColor(itemViewHolder.fUf, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(itemViewHolder.fUe, R.drawable.selector_load_more_bg);
            this.fTT.setClickable(true);
            this.fTT.setOnClickListener(this.fTS);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fTS = onClickListener;
    }

    public View getLastItemView() {
        return this.fTT;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.kAg.setClickable(true);
            itemViewHolder.kAg.setOnClickListener(this.fTY);
            view.setClickable(true);
            view.setOnClickListener(this.fTZ);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.extend_forum_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.fUe.setTag(aVar.forumAvatar);
            itemViewHolder.fUe.startLoad(aVar.forumAvatar, 10, false);
            itemViewHolder.fUf.setText(bf(aVar.forumName, 8));
            itemViewHolder.fUf.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.kAg.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.kAg.setTag(R.id.tag_forum_name, aVar.forumName);
            itemViewHolder.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            e(itemViewHolder.kAg, aVar.isLiked);
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void e(TextView textView, boolean z) {
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
            Iterator<ItemViewHolder> it = this.fTR.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fTT != null) {
                BarImageView barImageView = (BarImageView) this.fTT.findViewById(R.id.forum_avatar);
                ap.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ap.setImageResource(barImageView, R.drawable.icon_pic_more);
                ap.setViewTextColor((TextView) this.fTT.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(ItemViewHolder itemViewHolder, int i) {
        if (itemViewHolder != null && itemViewHolder.getView() != null) {
            if (itemViewHolder.kAg.getTag(R.id.forum_follow) != null && (itemViewHolder.kAg.getTag(R.id.forum_follow) instanceof Boolean)) {
                e(itemViewHolder.kAg, ((Boolean) itemViewHolder.kAg.getTag(R.id.forum_follow)).booleanValue());
            }
            ap.setViewTextColor(itemViewHolder.fUf, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j, boolean z) {
        Iterator<ItemViewHolder> it = this.fTR.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null && next.getView() != null && next.fUf.getTag(R.id.tag_forum_id) != null) {
                TextView textView = next.kAg;
                if (((Long) next.fUf.getTag(R.id.tag_forum_id)).longValue() == j) {
                    e(textView, z);
                    return;
                }
            }
        }
    }

    private String bf(String str, int i) {
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

    /* loaded from: classes7.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public BarImageView fUe;
        public TextView fUf;
        public TextView kAg;

        public ItemViewHolder(View view) {
            super(view);
            this.fUe = null;
            this.fUf = null;
            this.kAg = null;
            this.fUe = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fUe.setGifIconSupport(false);
            this.fUf = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.kAg = (TextView) view.findViewById(R.id.forum_add_love);
        }
    }
}
