package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes17.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aBk;
    private TextView dSz;
    private TextView hoE;
    private TextView hoF;
    private TextView hoJ;
    private RelativeLayout hoN;
    private TbImageView hoO;
    private TbImageView hoP;
    private TbImageView hoQ;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.btQ().dispatchMvcEvent(bVar);
                }
            }
        };
        this.dSz = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.hoE = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.hoF = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.hoJ = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.hoN = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.hoO = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.hoP = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.hoQ = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.hoO.setOnClickListener(this.aBk);
        this.hoP.setOnClickListener(this.aBk);
        this.hoQ.setOnClickListener(this.aBk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aq(final tinfo tinfoVar) {
        super.aq(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.dSz.setVisibility(8);
            } else {
                this.dSz.setVisibility(0);
                this.dSz.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.dSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (at.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.hoJ.setVisibility(8);
            } else {
                this.hoJ.setVisibility(0);
                this.hoJ.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.hoE.setVisibility(8);
            } else {
                this.hoE.setVisibility(0);
                this.hoE.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.hoF.setVisibility(8);
            } else {
                this.hoF.setVisibility(0);
                this.hoF.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bbM().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.hoN.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.hoQ.setVisibility(0);
                        this.hoQ.startLoad(str, 10, false);
                        this.hoQ.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.hoP.setVisibility(0);
                        this.hoP.startLoad(str2, 10, false);
                        this.hoP.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.hoO.setVisibility(0);
                this.hoO.startLoad(str3, 10, false);
                this.hoO.setTag(0);
                return;
            }
            this.hoN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
