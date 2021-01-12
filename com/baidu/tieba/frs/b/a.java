package com.baidu.tieba.frs.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static void a(bz bzVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        boolean z;
        int i2;
        String str;
        if (bzVar != null) {
            String str2 = null;
            int i3 = 0;
            boolean z2 = (bzVar.bnQ() == null || bzVar.bnQ().user_info == null || bzVar.bnQ().user_info.is_official != 2) ? false : true;
            boolean z3 = z2 && bzVar.bnQ().frsLiveStageType == 0;
            if (z3) {
                str2 = String.valueOf(bzVar.bnQ().live_id);
                i3 = 4;
            }
            if (!z3) {
                z3 = bzVar.getThreadType() == 41;
                if (z3) {
                    if (bzVar.bnd() != null) {
                        str2 = bzVar.bnd().getTaskId();
                    }
                    i3 = 2;
                }
            }
            if (bzVar.eRo) {
                z3 = true;
                str2 = bzVar.getId();
                i3 = 14;
            }
            if (bzVar.eRB) {
                z = true;
                str = bzVar.eRC;
                i2 = 17;
            } else {
                z = z3;
                i2 = i3;
                str = str2;
            }
            aq a2 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bzVar.eMg, z, str, (String) null, i2);
            if (a2 != null) {
                a2.an("list_order", c.cIR().a(bVar));
                if (bzVar.bpJ()) {
                    a2.an("gua_type", 1);
                } else if (bzVar.bpE() != null) {
                    a2.an("gua_type", 2);
                    int indexOf = a2.getParams().indexOf("obj_locate");
                    if (indexOf >= 0) {
                        a2.getParams().remove(indexOf + 1);
                        a2.getParams().add(indexOf + 1, 16);
                    } else {
                        a2.an("obj_locate", 16);
                    }
                } else {
                    a2.an("gua_type", 0);
                }
                a(a2, bzVar, tbPageTag);
                if (bzVar.bpJ()) {
                    a2.an("gua_type", 1);
                }
                if (z2) {
                    a2.an("obj_isofficial", bzVar.bnQ().user_info.is_official);
                }
                if (z2 || bzVar.eRo || bzVar.eRB) {
                    a2.delete("thread_type");
                    a2.an("thread_type", bzVar.getThreadType());
                }
                a(a2, tbPageTag, true);
                com.baidu.tieba.s.c.dKg().b(bdUniqueId, a2);
                d(bzVar, i);
            }
        }
    }

    private static void d(bz bzVar, int i) {
        aq aqVar = null;
        switch (i) {
            case 2:
                aqVar = com.baidu.tieba.s.a.a("c13692", bzVar, 2);
                break;
        }
        TiebaStatic.log(aqVar);
    }

    public static void a(bz bzVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        int i2;
        String str2;
        if (bzVar != null) {
            boolean z2 = (bzVar.bnQ() == null || bzVar.bnQ().user_info == null || bzVar.bnQ().user_info.is_official != 2) ? false : true;
            boolean z3 = z2 && bzVar.bnQ().frsLiveStageType == 0;
            if (z3) {
                str = String.valueOf(bzVar.bnQ().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z3) {
                z3 = bzVar.getThreadType() == 41;
                if (z3) {
                    if (bzVar.bnd() != null) {
                        str = bzVar.bnd().getTaskId();
                    }
                    i = 2;
                }
            }
            if (bzVar.eRo) {
                str = bzVar.getId();
                i = 14;
                z3 = true;
            }
            if (bzVar.eRB) {
                str2 = bzVar.eRC;
                i2 = 17;
                z = true;
            } else {
                z = z3;
                i2 = i;
                str2 = str;
            }
            aq a2 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.FRS, "common_exp", bzVar.eMg, z, str2, (String) null, i2);
            if (a2 != null) {
                a2.an("list_order", c.cIR().a(bVar));
                if (bzVar.bpJ()) {
                    a2.an("gua_type", 1);
                } else if (bzVar.bpE() != null) {
                    a2.an("gua_type", 2);
                } else {
                    a2.an("gua_type", 0);
                }
                a(a2, bzVar, tbPageTag);
                if (z2) {
                    a2.an("obj_isofficial", bzVar.bnQ().user_info.is_official);
                }
                if (z2 || bzVar.eRo || bzVar.eRB) {
                    a2.delete("thread_type");
                    a2.an("thread_type", bzVar.getThreadType());
                }
                a(a2, tbPageTag, false);
                com.baidu.tieba.s.c.dKg().a(bdUniqueId, com.baidu.tieba.s.a.a(bzVar.getTid(), str2, "", bzVar.getBaijiahaoData()), a2);
                if (bzVar.eRo) {
                    a(bzVar, bdUniqueId, tbPageTag);
                }
            }
        }
    }

    private static void a(aq aqVar, TbPageTag tbPageTag, boolean z) {
        int i;
        int i2 = 3;
        if (aqVar != null && tbPageTag != null) {
            if ("a070".equals(tbPageTag.locatePage)) {
                i = 1;
            } else if ("a071".equals(tbPageTag.locatePage)) {
                i = 2;
            } else if ("a072".equals(tbPageTag.locatePage)) {
                i = 3;
            } else if (502 == tbPageTag.tabId) {
                i = 5;
            } else if (92 == tbPageTag.tabType || 49 == tbPageTag.tabId || 1120 == tbPageTag.tabId || 1121 == tbPageTag.tabId) {
                i = 6;
            } else if (16 == tbPageTag.tabType) {
                i = 7;
            } else if (3 == tbPageTag.tabType) {
                i = 8;
            } else if (90 == tbPageTag.tabId) {
                i = 9;
            } else if (505 == tbPageTag.tabId) {
                i = 10;
            } else {
                i = tbPageTag.isGeneralTab == 1 ? 4 : 0;
            }
            if (z) {
                if (i > 0) {
                    aqVar.delete("obj_name");
                    aqVar.an("obj_name", i);
                }
            } else if (i > 0) {
                aqVar.delete("obj_locate");
                aqVar.an("obj_locate", i);
            }
            switch (tbPageTag.sortType) {
                case 1:
                    break;
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (i2 > 0) {
                if (i == 1 || i == 2) {
                    aqVar.delete("list_order");
                    aqVar.an("list_order", i2);
                }
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<n> list, ForumData forumData, int i) {
        if (!x.isEmpty(list)) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) instanceof com.baidu.tieba.InjectPlugin.a) {
                    i2++;
                }
                if (i2 > 0) {
                    a(bdUniqueId, i2, forumData, i, 0);
                } else {
                    return;
                }
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, int i, ForumData forumData, int i2, int i3) {
        if (i > 0) {
            aq a2 = com.baidu.tieba.s.a.a(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!at.isEmpty(forumData.getId())) {
                    a2.dW("fid", forumData.getId());
                }
                if (!at.isEmpty(forumData.getName())) {
                    a2.dW("fname", forumData.getName());
                }
                if (!at.isEmpty(forumData.getFirst_class())) {
                    a2.dW("first_dir", forumData.getFirst_class());
                }
                if (!at.isEmpty(forumData.getSecond_class())) {
                    a2.dW("second_dir", forumData.getSecond_class());
                }
            }
            a2.an("list_order", i2);
            com.baidu.tieba.s.c.dKg().b(bdUniqueId, a2);
        }
    }

    public static void a(bz bzVar, TbPageTag tbPageTag) {
        if (bzVar != null) {
            aq dW = new aq("common_click").dW("page_type", PageStayDurationConstants.PageName.FRS).an("obj_isad", 1).an("obj_adlocate", 15).dW("obj_id", bzVar.getId()).w("fid", bzVar.getFid()).an("obj_floor", bzVar.eMg).dW("tid", bzVar.getId()).an("thread_type", bzVar.getThreadType()).dW("first_dir", bzVar.bpi()).dW("second_dir", bzVar.bpj()).dW(IntentConfig.NID, bzVar.blV());
            a(dW, bzVar, tbPageTag);
            TiebaStatic.log(dW);
        }
    }

    private static void a(bz bzVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bzVar != null && bdUniqueId != null && bzVar.eRo) {
            boolean z = (bzVar.bnx() == null || bzVar.bnx().getUserId() == null || !bzVar.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bzVar.boP() && bzVar.getFeedBackReasonMap() != null && !z) {
                aq dW = new aq("common_exp").dW("page_type", PageStayDurationConstants.PageName.FRS).an("obj_isad", 1).an("obj_adlocate", 15).dW("obj_id", bzVar.getId()).an("obj_floor", bzVar.eMg).w("fid", bzVar.getFid()).an("thread_type", bzVar.getThreadType()).dW("tid", bzVar.getId()).dW("first_dir", bzVar.bpi()).dW("second_dir", bzVar.bpj());
                a(dW, bzVar, tbPageTag);
                com.baidu.tieba.s.c.dKg().a(bdUniqueId, com.baidu.tieba.s.a.a(bzVar.getTid(), "", "", bzVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dW);
            }
        }
    }

    private static void a(aq aqVar, bz bzVar, TbPageTag tbPageTag) {
        if (!at.isEmpty(bzVar.mRecomWeight)) {
            aqVar.dW("recom_weight", bzVar.mRecomWeight);
        }
        if (!at.isEmpty(bzVar.mRecomExtra)) {
            aqVar.dW("recom_extra", bzVar.mRecomExtra);
        }
        if (!at.isEmpty(bzVar.mRecomSource)) {
            aqVar.dW(IntentConfig.RECOM_SOURCE, bzVar.mRecomSource);
        }
        if (!at.isEmpty(bzVar.mRecomAbTag)) {
            aqVar.dW("recom_ab_tag", bzVar.mRecomAbTag);
        }
        aqVar.an("recom_type", bzVar.bpz());
        com.baidu.tbadk.pageInfo.c.a(aqVar, tbPageTag);
    }
}
