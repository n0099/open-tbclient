package com.baidu.tieba.forumMember.member;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel aHL;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.h item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == e.g.like_btn) {
                            if (ba.bG(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.kV()) {
                                    i.this.mPageContext.showToast(e.j.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.aHL.cF(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == e.g.detail_tip_view) {
                            String forumId2 = jVar.getForumId();
                            i.this.mPageContext.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(i.this.mContext, jVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.aHL == null) {
            ZD();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(e.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.axJ() != null) {
            int color = al.getColor(e.d.cp_other_b);
            int color2 = al.getColor(e.d.cp_cont_b);
            r axJ = jVar.axJ();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (axJ.isLike() == 1 && isLogin) {
                kVar.dyr.setVisibility(8);
                kVar.dys.setText(e.j.degree);
                al.c(kVar.dxs, BitmapHelper.getSmallGradeResourceIdNew(axJ.bxR()));
                if (StringUtils.isNull(axJ.getLevelName())) {
                    kVar.dxt.setVisibility(8);
                } else {
                    kVar.dxt.setText(axJ.getLevelName());
                    kVar.dxt.setVisibility(0);
                }
            } else {
                kVar.dyr.setVisibility(0);
                kVar.dys.setText(e.j.tbtille_just_be);
                al.c(kVar.dxs, BitmapHelper.getSmallGradeResourceIdNew(axJ.bxR()));
                kVar.dxt.setVisibility(8);
            }
            kVar.dyr.setTag(Integer.valueOf(i));
            kVar.dyt.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.mDivider.setVisibility(8);
                kVar.dyu.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(axJ.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + axJ.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.dyv.setText(spannableStringBuilder);
                kVar.mDivider.setVisibility(0);
                kVar.dyu.setVisibility(0);
            }
            al.j(kVar.dyw, e.d.cp_bg_line_d);
            al.j(kVar.dyx, e.d.cp_bg_line_c);
            al.j(kVar.dyy, e.d.cp_bg_line_b);
            al.j(kVar.mDivider, e.d.cp_bg_line_b);
            al.j(kVar.dyz, e.d.cp_bg_line_c);
            al.i(kVar.dyr, e.f.frs_btn_like);
            al.i(kVar.dxt, e.f.bg_bawu_level_title);
            al.c(kVar.dyA, e.d.cp_cont_c, 1);
            al.c(kVar.dyt, e.d.cp_cont_d, 1);
            kVar.dyt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
            al.c(kVar.dyr, e.d.white_alpha100, 1);
            al.c(kVar.dys, e.d.cp_cont_b, 1);
            al.c(kVar.dxt, e.d.cp_cont_c, 1);
            al.c(kVar.dyB, e.d.cp_cont_b, 1);
        }
        return view;
    }

    private void ZD() {
        if (this.mPageContext != null) {
            this.aHL = new LikeModel(this.mPageContext);
            this.aHL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof r) || i.this.aHL.getErrorCode() != 0) {
                        if (AntiHelper.ai(i.this.aHL.getErrorCode(), i.this.aHL.getErrorString())) {
                            AntiHelper.aG(i.this.mPageContext.getPageActivity(), i.this.aHL.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.aHL.getErrorString());
                            return;
                        }
                    }
                    r rVar = (r) obj;
                    rVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                }
            });
        }
    }
}
