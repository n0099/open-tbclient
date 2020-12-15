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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class x extends b<by> implements com.baidu.tieba.a.e {
    private by ahA;
    private String aiw;
    private final View fYf;
    private HeadImageView icz;
    private TextView ilu;
    private TextView ilv;
    private TextView ilw;
    private u ilx;
    private FrsBaseVideoView ily;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.icz = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.icz.setIsRound(true);
        this.icz.setDefaultResource(R.drawable.pic_head_topic);
        this.ilu = (TextView) view.findViewById(R.id.card_topic_name);
        this.ilw = (TextView) view.findViewById(R.id.card_thread_title);
        this.ilv = (TextView) view.findViewById(R.id.card_reply_time);
        this.fYf = view.findViewById(R.id.card_divider_line);
        this.ily = (FrsBaseVideoView) view.findViewById(R.id.base_video_view);
        this.ily.setClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.icz.invalidate();
        ap.setViewTextColor(this.ilu, R.color.CAM_X0105);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fYf, R.color.CAM_X0204);
        if (this.ily != null) {
            this.ily.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hottopic_video_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(by byVar) {
        if (byVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahA = byVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (this.ily != null) {
            this.ily.a(this.ahA, byVar.box());
        }
        if (byVar.boP() != null) {
            this.ilu.setText(byVar.boP().getName_show());
        }
        this.ilv.setText(au.getFormatTime(byVar.boI() * 1000));
        String str = byVar.bqw() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) byVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.ilw.setText(spannableStringBuilder);
        n.a(this.ilw, this.ahA.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahA != null) {
            if (crJ() != null) {
                crJ().a(view, (View) this.ahA, (Object) this.ilx);
            }
            n.Jq(this.ahA.getTid());
            n.a(this.ilw, this.ahA.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
            csi();
        }
    }

    private void csi() {
        if (this.ahA != null && this.ahA.boP() != null && this.ahA.boP().getName_show() != null) {
            if (com.baidu.tbadk.plugins.b.kV(true) && !com.baidu.tbadk.plugins.b.bFG()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.ahA.boP().getName_show() + "", "3");
                createNormalConfig.setExtra(this.ahA.getFid(), this.ahA.bqz(), this.ahA.bqA(), com.baidu.adp.lib.f.b.toLong(this.ahA.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            bf.bua().b(this.mPageContext, new String[]{this.ahA.bqB()});
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }
}
