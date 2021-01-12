package com.baidu.tbadk.widget.horizonalScrollListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout fQd;
    private final ArrayList<ItemViewHolder> fQe;
    private View.OnClickListener fQf;
    private View fQg;
    private String fQh;
    private String fQi;
    private CustomMessageListener fQj;
    private CustomMessageListener fQk;
    private View.OnClickListener fQl;
    private View.OnClickListener fQm;
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
            if (this.fQk != null) {
                this.fQk.setTag(this.mTag);
            }
            if (this.fQj != null) {
                this.fQj.setTag(this.mTag);
            }
        }
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setStatKey(String str, String str2) {
        this.fQh = str;
        this.fQi = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.fQe = new ArrayList<>();
        this.mSkinType = 3;
        this.fQf = null;
        this.mTag = null;
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fQl = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fQh)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fQh).an("obj_type", 1).dW("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new e() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                    w wVar = (w) obj;
                                    wVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, wVar.isLike() == 1);
                                } else if (AntiHelper.bQ(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bs(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gq(str, valueOf);
                    }
                }
            }
        };
        this.fQm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fQi)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fQi).dW("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQe = new ArrayList<>();
        this.mSkinType = 3;
        this.fQf = null;
        this.mTag = null;
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fQl = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fQh)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fQh).an("obj_type", 1).dW("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new e() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                    w wVar = (w) obj;
                                    wVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, wVar.isLike() == 1);
                                } else if (AntiHelper.bQ(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bs(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gq(str, valueOf);
                    }
                }
            }
        };
        this.fQm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fQi)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fQi).dW("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQe = new ArrayList<>();
        this.mSkinType = 3;
        this.fQf = null;
        this.mTag = null;
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fQl = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fQh)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fQh).an("obj_type", 1).dW("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new e() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                    w wVar = (w) obj;
                                    wVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, wVar.isLike() == 1);
                                } else if (AntiHelper.bQ(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bs(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gq(str, valueOf);
                    }
                }
            }
        };
        this.fQm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fQi)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fQi).dW("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
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
        this.fQd = new LinearLayout(context);
        this.fQd.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fQd.setOrientation(0);
        addView(this.fQd);
    }

    public void setData(List<a> list, TbPageContext<?> tbPageContext) {
        if (x.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new a());
            int count = x.getCount(this.fQe);
            int count2 = x.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) x.getItem(this.fQe, i);
                    if (viewHolder != null) {
                        this.fQd.removeView(viewHolder.getView());
                    }
                    this.fQe.remove(viewHolder);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                a aVar = (a) x.getItem(list, i2);
                ItemViewHolder itemViewHolder = (ItemViewHolder) x.getItem(this.fQe, i2);
                if (itemViewHolder != null) {
                    b(itemViewHolder.getView(), aVar);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        ItemViewHolder itemViewHolder2 = new ItemViewHolder(createView);
                        this.fQe.add(itemViewHolder2);
                        b(itemViewHolder2.getView(), aVar);
                        this.fQd.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.fQe.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fQj);
            this.mTbPageContext.registerListener(this.fQk);
            if (getTag() != null) {
                this.fQj.setTag(getTag());
                this.fQk.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(ItemViewHolder itemViewHolder) {
        if (itemViewHolder != null) {
            this.fQg = itemViewHolder.getView();
            itemViewHolder.fQu.setVisibility(8);
            itemViewHolder.fQs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            itemViewHolder.fQt.setVisibility(8);
            itemViewHolder.fQr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ao.setImageResource(itemViewHolder.fQr, R.drawable.icon_pic_more);
            ao.setViewTextColor(itemViewHolder.fQs, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(itemViewHolder.fQr, R.drawable.selector_load_more_bg);
            this.fQg.setClickable(true);
            this.fQg.setOnClickListener(this.fQf);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fQf = onClickListener;
    }

    public View getLastItemView() {
        return this.fQg;
    }

    private void a(View view, a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.fQu.setClickable(true);
            itemViewHolder.fQu.setOnClickListener(this.fQl);
            view.setClickable(true);
            view.setOnClickListener(this.fQm);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.fQr.setTag(aVar.forumAvatar);
            itemViewHolder.fQr.startLoad(aVar.forumAvatar, 10, false);
            itemViewHolder.fQs.setText(aVar.forumName);
            itemViewHolder.fQs.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.fQt.setDefaultBgResource(0);
            itemViewHolder.fQt.setDefaultResource(0);
            itemViewHolder.fQu.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.fQu.setTag(R.id.tag_forum_name, aVar.forumName);
            itemViewHolder.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(itemViewHolder.fQu, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    itemViewHolder.fQt.setVisibility(0);
                    ao.setImageResource(itemViewHolder.fQt, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    itemViewHolder.fQt.setVisibility(0);
                    ao.setImageResource(itemViewHolder.fQt, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    itemViewHolder.fQt.setVisibility(0);
                    ao.setImageResource(itemViewHolder.fQt, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    itemViewHolder.fQt.setVisibility(8);
                    break;
            }
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aM(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<ItemViewHolder> it = this.fQe.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fQg != null) {
                BarImageView barImageView = (BarImageView) this.fQg.findViewById(R.id.forum_avatar);
                ao.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ao.setImageResource(barImageView, R.drawable.icon_pic_more);
                ao.setViewTextColor((TextView) this.fQg.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            int count = x.getCount(this.fQe);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    ItemViewHolder itemViewHolder = (ItemViewHolder) x.getItem(this.fQe, i3);
                    if (itemViewHolder != null) {
                        switch (i3 + 1) {
                            case 1:
                                ao.setImageResource(itemViewHolder.fQt, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ao.setImageResource(itemViewHolder.fQt, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ao.setImageResource(itemViewHolder.fQt, R.drawable.icon_grade_shaitu3);
                                continue;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(ItemViewHolder itemViewHolder, int i) {
        if (itemViewHolder != null && itemViewHolder.getView() != null) {
            if (itemViewHolder.fQu.getTag(R.id.forum_follow) != null && (itemViewHolder.fQu.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(itemViewHolder.fQu, ((Boolean) itemViewHolder.fQu.getTag(R.id.forum_follow)).booleanValue());
            }
            ao.setViewTextColor(itemViewHolder.fQs, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j, boolean z) {
        Iterator<ItemViewHolder> it = this.fQe.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null && next.getView() != null && next.fQs.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.fQu;
                if (((Long) next.fQs.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public BarImageView fQr;
        public TextView fQs;
        public TbImageView fQt;
        public EntelechyUserLikeButton fQu;

        public ItemViewHolder(View view) {
            super(view);
            this.fQr = null;
            this.fQs = null;
            this.fQt = null;
            this.fQu = null;
            this.fQr = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fQr.setGifIconSupport(false);
            this.fQs = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.fQt = (TbImageView) view.findViewById(R.id.hot_rank);
            this.fQu = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
