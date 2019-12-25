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
/* loaded from: classes7.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aqZ;
    private TextView cGB;
    private TextView fIX;
    private TextView fIY;
    private TextView fJc;
    private RelativeLayout fJg;
    private TbImageView fJh;
    private TbImageView fJi;
    private TbImageView fJj;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aOf().dispatchMvcEvent(bVar);
                }
            }
        };
        this.cGB = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.fIX = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.fIY = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.fJc = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.fJg = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.fJh = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.fJi = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.fJj = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.fJh.setOnClickListener(this.aqZ);
        this.fJi.setOnClickListener(this.aqZ);
        this.fJj.setOnClickListener(this.aqZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(final tinfo tinfoVar) {
        super.ag(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.cGB.setVisibility(8);
            } else {
                this.cGB.setVisibility(0);
                this.cGB.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.cGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.fJc.setVisibility(8);
            } else {
                this.fJc.setVisibility(0);
                this.fJc.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.fIX.setVisibility(8);
            } else {
                this.fIX.setVisibility(0);
                this.fIX.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.fIY.setVisibility(8);
            } else {
                this.fIY.setVisibility(0);
                this.fIY.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.axf().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.fJg.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.fJj.setVisibility(0);
                        this.fJj.startLoad(str, 10, false);
                        this.fJj.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.fJi.setVisibility(0);
                        this.fJi.startLoad(str2, 10, false);
                        this.fJi.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.fJh.setVisibility(0);
                this.fJh.startLoad(str3, 10, false);
                this.fJh.setTag(0);
                return;
            }
            this.fJg.setVisibility(8);
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
