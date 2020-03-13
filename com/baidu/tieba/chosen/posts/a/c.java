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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener auY;
    private TextView cKS;
    private TextView fOR;
    private TextView fOS;
    private TextView fOW;
    private RelativeLayout fPa;
    private TbImageView fPb;
    private TbImageView fPc;
    private TbImageView fPd;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aQQ().dispatchMvcEvent(bVar);
                }
            }
        };
        this.cKS = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.fOR = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.fOS = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.fOW = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.fPa = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.fPb = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.fPc = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.fPd = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.fPb.setOnClickListener(this.auY);
        this.fPc.setOnClickListener(this.auY);
        this.fPd.setOnClickListener(this.auY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(final tinfo tinfoVar) {
        super.ai(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.cKS.setVisibility(8);
            } else {
                this.cKS.setVisibility(0);
                this.cKS.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.cKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (aq.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.fOW.setVisibility(8);
            } else {
                this.fOW.setVisibility(0);
                this.fOW.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.fOR.setVisibility(8);
            } else {
                this.fOR.setVisibility(0);
                this.fOR.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.fOS.setVisibility(8);
            } else {
                this.fOS.setVisibility(0);
                this.fOS.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.azO().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.fPa.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.fPd.setVisibility(0);
                        this.fPd.startLoad(str, 10, false);
                        this.fPd.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.fPc.setVisibility(0);
                        this.fPc.startLoad(str2, 10, false);
                        this.fPc.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.fPb.setVisibility(0);
                this.fPb.startLoad(str3, 10, false);
                this.fPb.setTag(0);
                return;
            }
            this.fPa.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
