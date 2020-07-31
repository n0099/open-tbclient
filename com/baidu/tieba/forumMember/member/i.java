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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes17.dex */
public class i extends com.baidu.tieba.frs.j<j, k> {
    private LikeModel emT;
    private int gzr;
    private int hBK;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gzr = 0;
        this.hBK = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.q item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bf.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.emT.fz(jVar.getForumName(), forumId);
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
    /* renamed from: bc */
    public k b(ViewGroup viewGroup) {
        if (this.emT == null) {
            bxF();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bZQ() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ao.getColor(R.color.cp_cont_d);
            u bZQ = jVar.bZQ();
            if (TbadkCoreApplication.isLogin()) {
                if (bZQ.isLike() == 1) {
                    kVar.hBO.setVisibility(8);
                    kVar.hBP.setVisibility(0);
                    kVar.hBP.setText(R.string.mydegree);
                    ao.setImageResource(kVar.hAN, BitmapHelper.getSmallGradeResourceIdNew(bZQ.diA()));
                    if (StringUtils.isNull(bZQ.getLevelName())) {
                        kVar.hAO.setVisibility(8);
                    } else {
                        kVar.hAO.setText(bZQ.getLevelName());
                        kVar.hAO.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bZQ.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bZQ.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.egJ.setText(spannableStringBuilder);
                    kVar.egJ.setVisibility(0);
                    kVar.hBU.setVisibility(0);
                    kVar.hBV.setVisibility(0);
                } else {
                    kVar.hBO.setVisibility(0);
                    kVar.hBP.setVisibility(8);
                    kVar.hAN.setVisibility(8);
                    kVar.hAO.setVisibility(8);
                    kVar.egJ.setVisibility(8);
                    kVar.hBU.setVisibility(8);
                    kVar.hBV.setVisibility(8);
                }
            } else {
                kVar.hBO.setVisibility(8);
                kVar.hBP.setVisibility(8);
                kVar.hAN.setVisibility(8);
                kVar.hAO.setVisibility(8);
                kVar.egJ.setVisibility(8);
                kVar.hBU.setVisibility(8);
                kVar.hBV.setVisibility(8);
            }
            kVar.hBO.setTag(Integer.valueOf(i));
            kVar.hAO.setTag(Integer.valueOf(i));
            kVar.hAO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ao.setBackgroundColor(kVar.hBR, R.color.cp_bg_line_d);
            ao.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            ao.setBackgroundColor(kVar.hBS, R.color.cp_bg_line_c);
            ao.setBackgroundResource(kVar.hBO, R.drawable.frs_btn_like);
            ao.setViewTextColor(kVar.hBO, R.color.white_alpha100, 1);
            ao.setViewTextColor(kVar.hBP, R.color.cp_cont_b, 1);
            ao.setViewTextColor(kVar.hAO, R.color.cp_cont_d, 1);
            ao.setViewTextColor(kVar.hBT, R.color.cp_cont_b, 1);
            ao.setBackgroundResource(kVar.hBU, R.drawable.forum_member_exp_progress);
            ao.setBackgroundColor(kVar.hBV, R.color.cp_bg_line_c);
            if (this.gzr != bZQ.diA() || this.hBK != bZQ.getCurScore()) {
                this.gzr = bZQ.diA();
                this.hBK = bZQ.getCurScore();
                kVar.hBU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, uq(this.gzr)));
                float f = 0.0f;
                this.hBK = bZQ.getCurScore();
                if (this.hBK > bZQ.getLevelupScore()) {
                    this.hBK = bZQ.getLevelupScore();
                }
                if (bZQ.getLevelupScore() != 0) {
                    f = this.hBK / bZQ.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.hBU, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bxF() {
        if (this.mPageContext != null) {
            this.emT = new LikeModel(this.mPageContext);
            this.emT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof u) || i.this.emT.getErrorCode() != 0) {
                        if (AntiHelper.bB(i.this.emT.getErrorCode(), i.this.emT.getErrorString())) {
                            AntiHelper.aW(i.this.mPageContext.getPageActivity(), i.this.emT.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.emT.getErrorString());
                            return;
                        }
                    }
                    u uVar = (u) obj;
                    uVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                }
            });
        }
    }

    private int[] uq(int i) {
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
