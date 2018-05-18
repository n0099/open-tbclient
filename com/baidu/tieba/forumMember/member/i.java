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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.f<j, k> {
    private LikeModel bnl;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.h item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view2.getId() == d.g.like_btn) {
                            if (az.aK(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.gP()) {
                                    i.this.mPageContext.showToast(d.k.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.bnl.cb(jVar.getForumName(), forumId);
                            }
                        } else if (view2.getId() == d.g.detail_tip_view) {
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
    /* renamed from: al */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.bnl == null) {
            PV();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.i.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view2, viewGroup, jVar, kVar);
        if (jVar != null && jVar.aoi() != null) {
            int color = ak.getColor(d.C0126d.cp_other_b);
            int color2 = ak.getColor(d.C0126d.cp_cont_b);
            r aoi = jVar.aoi();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (aoi.isLike() == 1 && isLogin) {
                kVar.cVn.setVisibility(8);
                kVar.cVo.setText(d.k.degree);
                ak.c(kVar.cUq, BitmapHelper.getSmallGradeResourceIdNew(aoi.box()));
                if (StringUtils.isNull(aoi.getLevelName())) {
                    kVar.cUr.setVisibility(8);
                } else {
                    kVar.cUr.setText(aoi.getLevelName());
                    kVar.cUr.setVisibility(0);
                }
            } else {
                kVar.cVn.setVisibility(0);
                kVar.cVo.setText(d.k.tbtille_just_be);
                ak.c(kVar.cUq, BitmapHelper.getSmallGradeResourceIdNew(aoi.box()));
                kVar.cUr.setVisibility(8);
            }
            kVar.cVn.setTag(Integer.valueOf(i));
            kVar.cVp.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.bxe.setVisibility(8);
                kVar.cVq.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(aoi.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + aoi.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.cVr.setText(spannableStringBuilder);
                kVar.bxe.setVisibility(0);
                kVar.cVq.setVisibility(0);
            }
            ak.j(kVar.cVs, d.C0126d.cp_bg_line_d);
            ak.j(kVar.cVt, d.C0126d.cp_bg_line_c);
            ak.j(kVar.cVu, d.C0126d.cp_bg_line_b);
            ak.j(kVar.bxe, d.C0126d.cp_bg_line_b);
            ak.j(kVar.cVv, d.C0126d.cp_bg_line_c);
            ak.i(kVar.cVn, d.f.frs_btn_like);
            ak.i(kVar.cUr, d.f.bg_bawu_level_title);
            ak.c(kVar.cVw, d.C0126d.cp_cont_c, 1);
            ak.c(kVar.cVp, d.C0126d.cp_cont_d, 1);
            kVar.cVp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            ak.c(kVar.cVn, d.C0126d.white_alpha100, 1);
            ak.c(kVar.cVo, d.C0126d.cp_cont_b, 1);
            ak.c(kVar.cUr, d.C0126d.cp_cont_c, 1);
            ak.c(kVar.cVx, d.C0126d.cp_cont_b, 1);
        }
        return view2;
    }

    private void PV() {
        if (this.mPageContext != null) {
            this.bnl = new LikeModel(this.mPageContext);
            this.bnl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    if (!(obj instanceof r) || i.this.bnl.getErrorCode() != 0) {
                        if (AntiHelper.ts(i.this.bnl.getErrorCode())) {
                            AntiHelper.am(i.this.mPageContext.getPageActivity(), i.this.bnl.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.bnl.getErrorString());
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
