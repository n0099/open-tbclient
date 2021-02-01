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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
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
    private LinearLayout fSq;
    private final ArrayList<ItemViewHolder> fSr;
    private View.OnClickListener fSs;
    private View fSt;
    private String fSu;
    private String fSv;
    private CustomMessageListener fSw;
    private CustomMessageListener fSx;
    private View.OnClickListener fSy;
    private View.OnClickListener fSz;
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
            if (this.fSx != null) {
                this.fSx.setTag(this.mTag);
            }
            if (this.fSw != null) {
                this.fSw.setTag(this.mTag);
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
        this.fSu = str;
        this.fSv = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.fSr = new ArrayList<>();
        this.mSkinType = 3;
        this.fSs = null;
        this.mTag = null;
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fSy = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (au.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fSu)) {
                            TiebaStatic.log(new ar(HorizonalScrollListView.this.fSu).ap("obj_type", 1).dR("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new e() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                    w wVar = (w) obj;
                                    wVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, wVar.isLike() == 1);
                                } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.br(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gw(str, valueOf);
                    }
                }
            }
        };
        this.fSz = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (au.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fSv)) {
                        TiebaStatic.log(new ar(HorizonalScrollListView.this.fSv).dR("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSr = new ArrayList<>();
        this.mSkinType = 3;
        this.fSs = null;
        this.mTag = null;
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fSy = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (au.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fSu)) {
                            TiebaStatic.log(new ar(HorizonalScrollListView.this.fSu).ap("obj_type", 1).dR("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new e() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                    w wVar = (w) obj;
                                    wVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, wVar.isLike() == 1);
                                } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.br(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gw(str, valueOf);
                    }
                }
            }
        };
        this.fSz = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (au.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fSv)) {
                        TiebaStatic.log(new ar(HorizonalScrollListView.this.fSv).dR("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSr = new ArrayList<>();
        this.mSkinType = 3;
        this.fSs = null;
        this.mTag = null;
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fSy = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (au.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fSu)) {
                            TiebaStatic.log(new ar(HorizonalScrollListView.this.fSu).ap("obj_type", 1).dR("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new e() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                if ((obj instanceof w) && likeModel.getErrorCode() == 0) {
                                    w wVar = (w) obj;
                                    wVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, wVar.isLike() == 1);
                                } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.br(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gw(str, valueOf);
                    }
                }
            }
        };
        this.fSz = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (au.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fSv)) {
                        TiebaStatic.log(new ar(HorizonalScrollListView.this.fSv).dR("fid", valueOf));
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
        this.fSq = new LinearLayout(context);
        this.fSq.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fSq.setOrientation(0);
        addView(this.fSq);
    }

    public void setData(List<a> list, TbPageContext<?> tbPageContext) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new a());
            int count = y.getCount(this.fSr);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) y.getItem(this.fSr, i);
                    if (viewHolder != null) {
                        this.fSq.removeView(viewHolder.getView());
                    }
                    this.fSr.remove(viewHolder);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                a aVar = (a) y.getItem(list, i2);
                ItemViewHolder itemViewHolder = (ItemViewHolder) y.getItem(this.fSr, i2);
                if (itemViewHolder != null) {
                    b(itemViewHolder.getView(), aVar);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        ItemViewHolder itemViewHolder2 = new ItemViewHolder(createView);
                        this.fSr.add(itemViewHolder2);
                        b(itemViewHolder2.getView(), aVar);
                        this.fSq.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.fSr.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fSw);
            this.mTbPageContext.registerListener(this.fSx);
            if (getTag() != null) {
                this.fSw.setTag(getTag());
                this.fSx.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(ItemViewHolder itemViewHolder) {
        if (itemViewHolder != null) {
            this.fSt = itemViewHolder.getView();
            itemViewHolder.fSH.setVisibility(8);
            itemViewHolder.fSF.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            itemViewHolder.fSG.setVisibility(8);
            itemViewHolder.fSE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ap.setImageResource(itemViewHolder.fSE, R.drawable.icon_pic_more);
            ap.setViewTextColor(itemViewHolder.fSF, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(itemViewHolder.fSE, R.drawable.selector_load_more_bg);
            this.fSt.setClickable(true);
            this.fSt.setOnClickListener(this.fSs);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fSs = onClickListener;
    }

    public View getLastItemView() {
        return this.fSt;
    }

    private void a(View view, a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.fSH.setClickable(true);
            itemViewHolder.fSH.setOnClickListener(this.fSy);
            view.setClickable(true);
            view.setOnClickListener(this.fSz);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            itemViewHolder.fSE.setTag(aVar.forumAvatar);
            itemViewHolder.fSE.startLoad(aVar.forumAvatar, 10, false);
            itemViewHolder.fSF.setText(aVar.forumName);
            itemViewHolder.fSF.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.fSG.setDefaultBgResource(0);
            itemViewHolder.fSG.setDefaultResource(0);
            itemViewHolder.fSH.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.fSH.setTag(R.id.tag_forum_name, aVar.forumName);
            itemViewHolder.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            itemViewHolder.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(itemViewHolder.fSH, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    itemViewHolder.fSG.setVisibility(0);
                    ap.setImageResource(itemViewHolder.fSG, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    itemViewHolder.fSG.setVisibility(0);
                    ap.setImageResource(itemViewHolder.fSG, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    itemViewHolder.fSG.setVisibility(0);
                    ap.setImageResource(itemViewHolder.fSG, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    itemViewHolder.fSG.setVisibility(8);
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
            Iterator<ItemViewHolder> it = this.fSr.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fSt != null) {
                BarImageView barImageView = (BarImageView) this.fSt.findViewById(R.id.forum_avatar);
                ap.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ap.setImageResource(barImageView, R.drawable.icon_pic_more);
                ap.setViewTextColor((TextView) this.fSt.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            int count = y.getCount(this.fSr);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    ItemViewHolder itemViewHolder = (ItemViewHolder) y.getItem(this.fSr, i3);
                    if (itemViewHolder != null) {
                        switch (i3 + 1) {
                            case 1:
                                ap.setImageResource(itemViewHolder.fSG, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ap.setImageResource(itemViewHolder.fSG, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ap.setImageResource(itemViewHolder.fSG, R.drawable.icon_grade_shaitu3);
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
            if (itemViewHolder.fSH.getTag(R.id.forum_follow) != null && (itemViewHolder.fSH.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(itemViewHolder.fSH, ((Boolean) itemViewHolder.fSH.getTag(R.id.forum_follow)).booleanValue());
            }
            ap.setViewTextColor(itemViewHolder.fSF, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j, boolean z) {
        Iterator<ItemViewHolder> it = this.fSr.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null && next.getView() != null && next.fSF.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.fSH;
                if (((Long) next.fSF.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public BarImageView fSE;
        public TextView fSF;
        public TbImageView fSG;
        public EntelechyUserLikeButton fSH;

        public ItemViewHolder(View view) {
            super(view);
            this.fSE = null;
            this.fSF = null;
            this.fSG = null;
            this.fSH = null;
            this.fSE = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fSE.setGifIconSupport(false);
            this.fSF = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.fSG = (TbImageView) view.findViewById(R.id.hot_rank);
            this.fSH = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
