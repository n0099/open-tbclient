package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class w extends b<bz> implements com.baidu.tieba.a.e {
    private bz aim;
    private String aji;
    private final View ghM;
    private HeadImageView ioZ;
    private TextView ixP;
    private TextView ixQ;
    private TextView ixR;
    private t ixS;
    private FrsBaseVideoView ixT;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.ioZ = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.ioZ.setIsRound(true);
        this.ioZ.setDefaultResource(R.drawable.pic_head_topic);
        this.ixP = (TextView) view.findViewById(R.id.card_topic_name);
        this.ixR = (TextView) view.findViewById(R.id.card_thread_title);
        this.ixQ = (TextView) view.findViewById(R.id.card_reply_time);
        this.ghM = view.findViewById(R.id.card_divider_line);
        this.ixT = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.ixT.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ioZ.invalidate();
        ao.setViewTextColor(this.ixP, R.color.CAM_X0105);
        ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ao.setBackgroundColor(this.ghM, R.color.CAM_X0204);
        if (this.ixT != null) {
            this.ixT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        if (bzVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aim = bzVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.ixT != null) {
            this.ixT.a(this.aim, bzVar.bqZ());
        }
        if (bzVar.brr() != null) {
            this.ixP.setText(bzVar.brr().getName_show());
        }
        this.ixQ.setText(at.getFormatTime(bzVar.brk() * 1000));
        String str = bzVar.bsZ() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bzVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.ixR.setText(spannableStringBuilder);
        m.a(this.ixR, this.aim.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aim != null) {
            if (cuD() != null) {
                cuD().a(view, (View) this.aim, (Object) this.ixS);
            }
            m.Jn(this.aim.getTid());
            m.a(this.ixR, this.aim.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
            cvc();
        }
    }

    private void cvc() {
        if (this.aim != null && this.aim.brr() != null && this.aim.brr().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.lr(true) && !com.baidu.tbadk.plugins.b.bIc()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.aim.brr().getName_show() + "", "3");
                createNormalConfig.setExtra(this.aim.getFid(), this.aim.btc(), this.aim.btd(), com.baidu.adp.lib.f.b.toLong(this.aim.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bwv().b(this.mPageContext, new String[]{this.aim.bte()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }
}
