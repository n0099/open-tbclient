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
import com.baidu.adp.widget.ListView.y;
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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout ele;
    private final ArrayList<a> elf;
    private View.OnClickListener elg;
    private View elh;
    private String eli;
    private String elj;
    private CustomMessageListener elk;
    private CustomMessageListener ell;
    private View.OnClickListener elm;
    private View.OnClickListener eln;
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
            if (this.ell != null) {
                this.ell.setTag(this.mTag);
            }
            if (this.elk != null) {
                this.elk.setTag(this.mTag);
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
        this.eli = str;
        this.elj = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.elf = new ArrayList<>();
        this.mSkinType = 3;
        this.elg = null;
        this.mTag = null;
        this.elk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ell = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.elm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.eli)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.eli).af("obj_type", 1).cI("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bq(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bi(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.eP(str, valueOf);
                    }
                }
            }
        };
        this.eln = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.elj)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.elj).cI("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elf = new ArrayList<>();
        this.mSkinType = 3;
        this.elg = null;
        this.mTag = null;
        this.elk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ell = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.elm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.eli)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.eli).af("obj_type", 1).cI("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bq(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bi(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.eP(str, valueOf);
                    }
                }
            }
        };
        this.eln = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.elj)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.elj).cI("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.elf = new ArrayList<>();
        this.mSkinType = 3;
        this.elg = null;
        this.mTag = null;
        this.elk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ell = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.elm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.eli)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.eli).af("obj_type", 1).cI("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bq(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bi(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.eP(str, valueOf);
                    }
                }
            }
        };
        this.eln = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.elj)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.elj).cI("fid", valueOf));
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
        this.ele = new LinearLayout(context);
        this.ele.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.ele.setOrientation(0);
        addView(this.ele);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = v.getCount(this.elf);
            int count2 = v.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    y.a aVar = (y.a) v.getItem(this.elf, i);
                    if (aVar != null) {
                        this.ele.removeView(aVar.getView());
                    }
                    this.elf.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.getItem(list, i2);
                a aVar3 = (a) v.getItem(this.elf, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.elf.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.ele.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.elf.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.elk);
            this.mTbPageContext.registerListener(this.ell);
            if (getTag() != null) {
                this.elk.setTag(getTag());
                this.ell.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.elh = aVar.getView();
            aVar.elv.setVisibility(8);
            aVar.elt.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.elu.setVisibility(8);
            aVar.els.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.setImageResource(aVar.els, R.drawable.icon_pic_more);
            am.setViewTextColor(aVar.elt, R.color.cp_cont_b, 1);
            am.setBackgroundResource(aVar.els, R.drawable.selector_load_more_bg);
            this.elh.setClickable(true);
            this.elh.setOnClickListener(this.elg);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.elg = onClickListener;
    }

    public View getLastItemView() {
        return this.elh;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.elv.setClickable(true);
            aVar2.elv.setOnClickListener(this.elm);
            view.setClickable(true);
            view.setOnClickListener(this.eln);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.els.setTag(aVar.forumAvatar);
            aVar2.els.startLoad(aVar.forumAvatar, 10, false);
            aVar2.elt.setText(aVar.forumName);
            aVar2.elt.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.elu.setDefaultBgResource(0);
            aVar2.elu.setDefaultResource(0);
            aVar2.elv.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.elv.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.elv, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.elu.setVisibility(0);
                    am.setImageResource(aVar2.elu, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.elu.setVisibility(0);
                    am.setImageResource(aVar2.elu, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.elu.setVisibility(0);
                    am.setImageResource(aVar2.elu, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.elu.setVisibility(8);
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
            entelechyUserLikeButton.gT(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.elf.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.elh != null) {
                BarImageView barImageView = (BarImageView) this.elh.findViewById(R.id.forum_avatar);
                am.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                am.setImageResource(barImageView, R.drawable.icon_pic_more);
                am.setViewTextColor((TextView) this.elh.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = v.getCount(this.elf);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) v.getItem(this.elf, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.setImageResource(aVar.elu, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.setImageResource(aVar.elu, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.setImageResource(aVar.elu, R.drawable.icon_grade_shaitu3);
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
            if (aVar.elv.getTag(R.id.forum_follow) != null && (aVar.elv.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.elv, ((Boolean) aVar.elv.getTag(R.id.forum_follow)).booleanValue());
            }
            am.setViewTextColor(aVar.elt, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, boolean z) {
        Iterator<a> it = this.elf.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.elt.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.elv;
                if (((Long) next.elt.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends y.a {
        public BarImageView els;
        public TextView elt;
        public TbImageView elu;
        public EntelechyUserLikeButton elv;

        public a(View view) {
            super(view);
            this.els = null;
            this.elt = null;
            this.elu = null;
            this.elv = null;
            this.els = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.els.setGifIconSupport(false);
            this.elt = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.elu = (TbImageView) view.findViewById(R.id.hot_rank);
            this.elv = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
