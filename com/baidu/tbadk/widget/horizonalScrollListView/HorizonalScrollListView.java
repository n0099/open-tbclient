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
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout faq;
    private final ArrayList<a> far;
    private View.OnClickListener fas;
    private View fat;
    private String fau;
    private String fav;
    private CustomMessageListener faw;
    private CustomMessageListener fax;
    private View.OnClickListener fay;
    private View.OnClickListener faz;
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
            if (this.fax != null) {
                this.fax.setTag(this.mTag);
            }
            if (this.faw != null) {
                this.faw.setTag(this.mTag);
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
        this.fau = str;
        this.fav = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.far = new ArrayList<>();
        this.mSkinType = 3;
        this.fas = null;
        this.mTag = null;
        this.faw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fax = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fay = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fau)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fau).ai("obj_type", 1).dD("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bz(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bb(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fQ(str, valueOf);
                    }
                }
            }
        };
        this.faz = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fav)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fav).dD("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dL(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.far = new ArrayList<>();
        this.mSkinType = 3;
        this.fas = null;
        this.mTag = null;
        this.faw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fax = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fay = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fau)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fau).ai("obj_type", 1).dD("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bz(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bb(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fQ(str, valueOf);
                    }
                }
            }
        };
        this.faz = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fav)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fav).dD("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dL(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.far = new ArrayList<>();
        this.mSkinType = 3;
        this.fas = null;
        this.mTag = null;
        this.faw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fax = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fay = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fau)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fau).ai("obj_type", 1).dD("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bz(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bb(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fQ(str, valueOf);
                    }
                }
            }
        };
        this.faz = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fav)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fav).dD("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dL(context);
    }

    private void dL(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.faq = new LinearLayout(context);
        this.faq.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.faq.setOrientation(0);
        addView(this.faq);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = y.getCount(this.far);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    af.a aVar = (af.a) y.getItem(this.far, i);
                    if (aVar != null) {
                        this.faq.removeView(aVar.getView());
                    }
                    this.far.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) y.getItem(list, i2);
                a aVar3 = (a) y.getItem(this.far, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.far.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.faq.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.far.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.faw);
            this.mTbPageContext.registerListener(this.fax);
            if (getTag() != null) {
                this.faw.setTag(getTag());
                this.fax.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.fat = aVar.getView();
            aVar.faH.setVisibility(8);
            aVar.faF.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.faG.setVisibility(8);
            aVar.faE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ap.setImageResource(aVar.faE, R.drawable.icon_pic_more);
            ap.setViewTextColor(aVar.faF, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(aVar.faE, R.drawable.selector_load_more_bg);
            this.fat.setClickable(true);
            this.fat.setOnClickListener(this.fas);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fas = onClickListener;
    }

    public View getLastItemView() {
        return this.fat;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.faH.setClickable(true);
            aVar2.faH.setOnClickListener(this.fay);
            view.setClickable(true);
            view.setOnClickListener(this.faz);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.faE.setTag(aVar.forumAvatar);
            aVar2.faE.startLoad(aVar.forumAvatar, 10, false);
            aVar2.faF.setText(aVar.forumName);
            aVar2.faF.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.faG.setDefaultBgResource(0);
            aVar2.faG.setDefaultResource(0);
            aVar2.faH.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.faH.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.faH, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.faG.setVisibility(0);
                    ap.setImageResource(aVar2.faG, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.faG.setVisibility(0);
                    ap.setImageResource(aVar2.faG, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.faG.setVisibility(0);
                    ap.setImageResource(aVar2.faG, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.faG.setVisibility(8);
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
            entelechyUserLikeButton.aN(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.far.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fat != null) {
                BarImageView barImageView = (BarImageView) this.fat.findViewById(R.id.forum_avatar);
                ap.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ap.setImageResource(barImageView, R.drawable.icon_pic_more);
                ap.setViewTextColor((TextView) this.fat.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = y.getCount(this.far);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) y.getItem(this.far, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                ap.setImageResource(aVar.faG, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ap.setImageResource(aVar.faG, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ap.setImageResource(aVar.faG, R.drawable.icon_grade_shaitu3);
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
    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.faH.getTag(R.id.forum_follow) != null && (aVar.faH.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.faH, ((Boolean) aVar.faH.getTag(R.id.forum_follow)).booleanValue());
            }
            ap.setViewTextColor(aVar.faF, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, boolean z) {
        Iterator<a> it = this.far.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.faF.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.faH;
                if (((Long) next.faF.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class a extends af.a {
        public BarImageView faE;
        public TextView faF;
        public TbImageView faG;
        public EntelechyUserLikeButton faH;

        public a(View view) {
            super(view);
            this.faE = null;
            this.faF = null;
            this.faG = null;
            this.faH = null;
            this.faE = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.faE.setGifIconSupport(false);
            this.faF = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.faG = (TbImageView) view.findViewById(R.id.hot_rank);
            this.faH = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
