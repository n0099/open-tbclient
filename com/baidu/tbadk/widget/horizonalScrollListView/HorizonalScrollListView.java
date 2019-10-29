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
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout cSW;
    private final ArrayList<a> cSX;
    private View.OnClickListener cSY;
    private View cSZ;
    private String cTa;
    private String cTb;
    private CustomMessageListener cTc;
    private CustomMessageListener cTd;
    private View.OnClickListener cTe;
    private View.OnClickListener cTf;
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
            if (this.cTd != null) {
                this.cTd.setTag(this.mTag);
            }
            if (this.cTc != null) {
                this.cTc.setTag(this.mTag);
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
        this.cTa = str;
        this.cTb = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.cSX = new ArrayList<>();
        this.mSkinType = 3;
        this.cSY = null;
        this.mTag = null;
        this.cTc = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cTd = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cTe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cTa)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cTa).O("obj_type", 1).bS("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aH(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aS(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dY(str, valueOf);
                    }
                }
            }
        };
        this.cTf = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cTb)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cTb).bS("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSX = new ArrayList<>();
        this.mSkinType = 3;
        this.cSY = null;
        this.mTag = null;
        this.cTc = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cTd = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cTe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cTa)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cTa).O("obj_type", 1).bS("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aH(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aS(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dY(str, valueOf);
                    }
                }
            }
        };
        this.cTf = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cTb)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cTb).bS("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cSX = new ArrayList<>();
        this.mSkinType = 3;
        this.cSY = null;
        this.mTag = null;
        this.cTc = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cTd = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cTe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cTa)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cTa).O("obj_type", 1).bS("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aH(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aS(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dY(str, valueOf);
                    }
                }
            }
        };
        this.cTf = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cTb)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cTb).bS("fid", valueOf));
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
        this.cSW = new LinearLayout(context);
        this.cSW.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.cSW.setOrientation(0);
        addView(this.cSW);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = v.getCount(this.cSX);
            int count2 = v.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.getItem(this.cSX, i);
                    if (aVar != null) {
                        this.cSW.removeView(aVar.getView());
                    }
                    this.cSX.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.getItem(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.getItem(this.cSX, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.cSX.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.cSW.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.cSX.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.cTc);
            this.mTbPageContext.registerListener(this.cTd);
            if (getTag() != null) {
                this.cTc.setTag(getTag());
                this.cTd.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.cSZ = aVar.getView();
            aVar.cTn.setVisibility(8);
            aVar.cTl.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.cTm.setVisibility(8);
            aVar.cTk.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.setImageResource(aVar.cTk, R.drawable.icon_pic_more);
            am.setViewTextColor(aVar.cTl, R.color.cp_cont_b, 1);
            am.setBackgroundResource(aVar.cTk, R.drawable.selector_load_more_bg);
            this.cSZ.setClickable(true);
            this.cSZ.setOnClickListener(this.cSY);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.cSY = onClickListener;
    }

    public View getLastItemView() {
        return this.cSZ;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cTn.setClickable(true);
            aVar2.cTn.setOnClickListener(this.cTe);
            view.setClickable(true);
            view.setOnClickListener(this.cTf);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cTk.setTag(aVar.forumAvatar);
            aVar2.cTk.startLoad(aVar.forumAvatar, 10, false);
            aVar2.cTl.setText(aVar.forumName);
            aVar2.cTl.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cTm.setDefaultBgResource(0);
            aVar2.cTm.setDefaultResource(0);
            aVar2.cTn.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cTn.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.cTn, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.cTm.setVisibility(0);
                    am.setImageResource(aVar2.cTm, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.cTm.setVisibility(0);
                    am.setImageResource(aVar2.cTm, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.cTm.setVisibility(0);
                    am.setImageResource(aVar2.cTm, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.cTm.setVisibility(8);
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
            entelechyUserLikeButton.ew(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.cSX.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.cSZ != null) {
                BarImageView barImageView = (BarImageView) this.cSZ.findViewById(R.id.forum_avatar);
                am.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                am.setImageResource(barImageView, R.drawable.icon_pic_more);
                am.setViewTextColor((TextView) this.cSZ.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.cSX);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.getItem(this.cSX, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.setImageResource(aVar.cTm, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.setImageResource(aVar.cTm, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.setImageResource(aVar.cTm, R.drawable.icon_grade_shaitu3);
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
            if (aVar.cTn.getTag(R.id.forum_follow) != null && (aVar.cTn.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.cTn, ((Boolean) aVar.cTn.getTag(R.id.forum_follow)).booleanValue());
            }
            am.setViewTextColor(aVar.cTl, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.cSX.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.cTl.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.cTn;
                if (((Long) next.cTl.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public BarImageView cTk;
        public TextView cTl;
        public TbImageView cTm;
        public EntelechyUserLikeButton cTn;

        public a(View view) {
            super(view);
            this.cTk = null;
            this.cTl = null;
            this.cTm = null;
            this.cTn = null;
            this.cTk = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.cTk.setGifIconSupport(false);
            this.cTl = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.cTm = (TbImageView) view.findViewById(R.id.hot_rank);
            this.cTn = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
