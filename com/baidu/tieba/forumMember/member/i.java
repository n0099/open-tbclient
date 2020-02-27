package com.baidu.tieba.forumMember.member;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes10.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel djT;
    private int fmU;
    private int gkK;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fmU = 0;
        this.gkK = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.m item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bc.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.djT.eC(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String forumId2 = jVar.getForumId();
                            i.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_TBTITLE_ACTIVITY, new TbTitleActivityConfig(i.this.mContext, jVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public k b(ViewGroup viewGroup) {
        if (this.djT == null) {
            bdc();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bCv() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.t bCv = jVar.bCv();
            if (TbadkCoreApplication.isLogin()) {
                if (bCv.isLike() == 1) {
                    kVar.gkO.setVisibility(8);
                    kVar.gkP.setVisibility(0);
                    kVar.gkP.setText(R.string.mydegree);
                    am.setImageResource(kVar.gjL, BitmapHelper.getSmallGradeResourceIdNew(bCv.cII()));
                    if (StringUtils.isNull(bCv.getLevelName())) {
                        kVar.gjM.setVisibility(8);
                    } else {
                        kVar.gjM.setText(bCv.getLevelName());
                        kVar.gjM.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bCv.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bCv.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.gkR.setText(spannableStringBuilder);
                    kVar.gkR.setVisibility(0);
                    kVar.gkV.setVisibility(0);
                    kVar.gkW.setVisibility(0);
                } else {
                    kVar.gkO.setVisibility(0);
                    kVar.gkP.setVisibility(8);
                    kVar.gjL.setVisibility(8);
                    kVar.gjM.setVisibility(8);
                    kVar.gkR.setVisibility(8);
                    kVar.gkV.setVisibility(8);
                    kVar.gkW.setVisibility(8);
                }
            } else {
                kVar.gkO.setVisibility(8);
                kVar.gkP.setVisibility(8);
                kVar.gjL.setVisibility(8);
                kVar.gjM.setVisibility(8);
                kVar.gkR.setVisibility(8);
                kVar.gkV.setVisibility(8);
                kVar.gkW.setVisibility(8);
            }
            kVar.gkO.setTag(Integer.valueOf(i));
            kVar.gjM.setTag(Integer.valueOf(i));
            kVar.gjM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.setBackgroundColor(kVar.gkS, R.color.cp_bg_line_d);
            am.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(kVar.gkT, R.color.cp_bg_line_c);
            am.setBackgroundResource(kVar.gkO, R.drawable.frs_btn_like);
            am.setViewTextColor(kVar.gkO, R.color.white_alpha100, 1);
            am.setViewTextColor(kVar.gkP, R.color.cp_cont_b, 1);
            am.setViewTextColor(kVar.gjM, R.color.cp_cont_d, 1);
            am.setViewTextColor(kVar.gkU, R.color.cp_cont_b, 1);
            am.setBackgroundResource(kVar.gkV, R.drawable.forum_member_exp_progress);
            am.setBackgroundColor(kVar.gkW, R.color.cp_bg_line_c);
            if (this.fmU != bCv.cII() || this.gkK != bCv.getCurScore()) {
                this.fmU = bCv.cII();
                this.gkK = bCv.getCurScore();
                kVar.gkV.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sr(this.fmU)));
                float f = 0.0f;
                this.gkK = bCv.getCurScore();
                if (this.gkK > bCv.getLevelupScore()) {
                    this.gkK = bCv.getLevelupScore();
                }
                if (bCv.getLevelupScore() != 0) {
                    f = this.gkK / bCv.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.gkV, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bdc() {
        if (this.mPageContext != null) {
            this.djT = new LikeModel(this.mPageContext);
            this.djT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.djT.getErrorCode() != 0) {
                        if (AntiHelper.bb(i.this.djT.getErrorCode(), i.this.djT.getErrorString())) {
                            AntiHelper.bn(i.this.mPageContext.getPageActivity(), i.this.djT.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.djT.getErrorString());
                            return;
                        }
                    }
                    com.baidu.tieba.tbadkCore.t tVar = (com.baidu.tieba.tbadkCore.t) obj;
                    tVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                }
            });
        }
    }

    private int[] sr(int i) {
        if (i <= 3) {
            return new int[]{-8331843, -10499102};
        }
        if (i <= 9) {
            return new int[]{-10499102, -154262};
        }
        if (i <= 15) {
            return new int[]{-154262, -148180};
        }
        return new int[]{-148180, -100818};
    }
}
