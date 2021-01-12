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
/* loaded from: classes7.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aCu;
    private RelativeLayout blF;
    private TextView eFr;
    private TextView iwD;
    private TextView iwE;
    private TextView iwI;
    private TbImageView iwM;
    private TbImageView iwN;
    private TbImageView iwO;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bDq().dispatchMvcEvent(bVar);
                }
            }
        };
        this.eFr = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.iwD = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.iwE = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.iwI = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.blF = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.iwM = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.iwN = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.iwO = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.iwM.setOnClickListener(this.aCu);
        this.iwN.setOnClickListener(this.aCu);
        this.iwO.setOnClickListener(this.aCu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(final tinfo tinfoVar) {
        super.aw(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.eFr.setVisibility(8);
            } else {
                this.eFr.setVisibility(0);
                this.eFr.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.eFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.iwI.setVisibility(8);
            } else {
                this.iwI.setVisibility(0);
                this.iwI.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.iwD.setVisibility(8);
            } else {
                this.iwD.setVisibility(0);
                this.iwD.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.iwE.setVisibility(8);
            } else {
                this.iwE.setVisibility(0);
                this.iwE.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bkB().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.blF.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.iwO.setVisibility(0);
                        this.iwO.startLoad(str, 10, false);
                        this.iwO.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.iwN.setVisibility(0);
                        this.iwN.startLoad(str2, 10, false);
                        this.iwN.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.iwM.setVisibility(0);
                this.iwM.startLoad(str3, 10, false);
                this.iwM.setTag(0);
                return;
            }
            this.blF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
