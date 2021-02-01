package com.baidu.tieba.frs.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static void a(cb cbVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        boolean z;
        int i2;
        String str;
        if (cbVar != null) {
            String str2 = null;
            int i3 = 0;
            boolean z2 = (cbVar.boj() == null || cbVar.boj().user_info == null || cbVar.boj().user_info.is_official != 2) ? false : true;
            boolean z3 = z2 && cbVar.boj().frsLiveStageType == 0;
            if (z3) {
                str2 = String.valueOf(cbVar.boj().live_id);
                i3 = 4;
            }
            if (!z3) {
                z3 = cbVar.getThreadType() == 41;
                if (z3) {
                    if (cbVar.bnw() != null) {
                        str2 = cbVar.bnw().getTaskId();
                    }
                    i3 = 2;
                }
            }
            if (cbVar.eTA) {
                z3 = true;
                str2 = cbVar.getId();
                i3 = 14;
            }
            if (cbVar.eTP) {
                z = true;
                str = cbVar.eTQ;
                i2 = 17;
            } else {
                z = z3;
                i2 = i3;
                str = str2;
            }
            ar a2 = com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.FRS, "common_click", i, cbVar.eOs, z, str, (String) null, i2);
            if (a2 != null) {
                a2.ap("list_order", c.cKe().a(bVar));
                if (cbVar.bqb()) {
                    a2.ap("gua_type", 1);
                } else if (cbVar.bpW() != null) {
                    a2.ap("gua_type", 2);
                    int indexOf = a2.getParams().indexOf("obj_locate");
                    if (indexOf >= 0) {
                        a2.getParams().remove(indexOf + 1);
                        a2.getParams().add(indexOf + 1, 16);
                    } else {
                        a2.ap("obj_locate", 16);
                    }
                } else {
                    a2.ap("gua_type", 0);
                }
                a(a2, cbVar, tbPageTag);
                if (cbVar.bqb()) {
                    a2.ap("gua_type", 1);
                }
                if (z2) {
                    a2.ap("obj_isofficial", cbVar.boj().user_info.is_official);
                }
                if (z2 || cbVar.eTA || cbVar.eTP) {
                    a2.delete("thread_type");
                    a2.ap("thread_type", cbVar.getThreadType());
                }
                a(a2, tbPageTag, true);
                com.baidu.tieba.s.c.dMr().b(bdUniqueId, a2);
                d(cbVar, i);
            }
        }
    }

    private static void d(cb cbVar, int i) {
        ar arVar = null;
        switch (i) {
            case 2:
                arVar = com.baidu.tieba.s.a.a("c13692", cbVar, 2);
                break;
        }
        TiebaStatic.log(arVar);
    }

    public static void a(cb cbVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        int i2;
        String str2;
        if (cbVar != null) {
            boolean z2 = (cbVar.boj() == null || cbVar.boj().user_info == null || cbVar.boj().user_info.is_official != 2) ? false : true;
            boolean z3 = z2 && cbVar.boj().frsLiveStageType == 0;
            if (z3) {
                str = String.valueOf(cbVar.boj().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z3) {
                z3 = cbVar.getThreadType() == 41;
                if (z3) {
                    if (cbVar.bnw() != null) {
                        str = cbVar.bnw().getTaskId();
                    }
                    i = 2;
                }
            }
            if (cbVar.eTA) {
                str = cbVar.getId();
                i = 14;
                z3 = true;
            }
            if (cbVar.eTP) {
                str2 = cbVar.eTQ;
                i2 = 17;
                z = true;
            } else {
                z = z3;
                i2 = i;
                str2 = str;
            }
            ar a2 = com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.FRS, "common_exp", cbVar.eOs, z, str2, (String) null, i2);
            if (a2 != null) {
                a2.ap("list_order", c.cKe().a(bVar));
                if (cbVar.bqb()) {
                    a2.ap("gua_type", 1);
                } else if (cbVar.bpW() != null) {
                    a2.ap("gua_type", 2);
                } else {
                    a2.ap("gua_type", 0);
                }
                a(a2, cbVar, tbPageTag);
                if (z2) {
                    a2.ap("obj_isofficial", cbVar.boj().user_info.is_official);
                }
                if (z2 || cbVar.eTA || cbVar.eTP) {
                    a2.delete("thread_type");
                    a2.ap("thread_type", cbVar.getThreadType());
                }
                a(a2, tbPageTag, false);
                com.baidu.tieba.s.c.dMr().a(bdUniqueId, com.baidu.tieba.s.a.a(cbVar.getTid(), str2, "", cbVar.getBaijiahaoData()), a2);
                if (cbVar.eTA) {
                    a(cbVar, bdUniqueId, tbPageTag);
                }
            }
        }
    }

    private static void a(ar arVar, TbPageTag tbPageTag, boolean z) {
        int i;
        int i2 = 3;
        if (arVar != null && tbPageTag != null) {
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
                    arVar.delete("obj_name");
                    arVar.ap("obj_name", i);
                }
            } else if (i > 0) {
                arVar.delete("obj_locate");
                arVar.ap("obj_locate", i);
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
                    arVar.delete("list_order");
                    arVar.ap("list_order", i2);
                }
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<n> list, ForumData forumData, int i) {
        if (!y.isEmpty(list)) {
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
            ar a2 = com.baidu.tieba.s.a.a(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!au.isEmpty(forumData.getId())) {
                    a2.dR("fid", forumData.getId());
                }
                if (!au.isEmpty(forumData.getName())) {
                    a2.dR("fname", forumData.getName());
                }
                if (!au.isEmpty(forumData.getFirst_class())) {
                    a2.dR("first_dir", forumData.getFirst_class());
                }
                if (!au.isEmpty(forumData.getSecond_class())) {
                    a2.dR("second_dir", forumData.getSecond_class());
                }
            }
            a2.ap("list_order", i2);
            com.baidu.tieba.s.c.dMr().b(bdUniqueId, a2);
        }
    }

    public static void a(cb cbVar, TbPageTag tbPageTag) {
        if (cbVar != null) {
            ar dR = new ar("common_click").dR("page_type", PageStayDurationConstants.PageName.FRS).ap("obj_isad", 1).ap("obj_adlocate", 15).dR("obj_id", cbVar.getId()).v("fid", cbVar.getFid()).ap("obj_floor", cbVar.eOs).dR("tid", cbVar.getId()).ap("thread_type", cbVar.getThreadType()).dR("first_dir", cbVar.bpA()).dR("second_dir", cbVar.bpB()).dR(IntentConfig.NID, cbVar.bmo());
            a(dR, cbVar, tbPageTag);
            TiebaStatic.log(dR);
        }
    }

    private static void a(cb cbVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (cbVar != null && bdUniqueId != null && cbVar.eTA) {
            boolean z = (cbVar.bnQ() == null || cbVar.bnQ().getUserId() == null || !cbVar.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (cbVar.bph() && cbVar.getFeedBackReasonMap() != null && !z) {
                ar dR = new ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.FRS).ap("obj_isad", 1).ap("obj_adlocate", 15).dR("obj_id", cbVar.getId()).ap("obj_floor", cbVar.eOs).v("fid", cbVar.getFid()).ap("thread_type", cbVar.getThreadType()).dR("tid", cbVar.getId()).dR("first_dir", cbVar.bpA()).dR("second_dir", cbVar.bpB());
                a(dR, cbVar, tbPageTag);
                com.baidu.tieba.s.c.dMr().a(bdUniqueId, com.baidu.tieba.s.a.a(cbVar.getTid(), "", "", cbVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dR);
            }
        }
    }

    private static void a(ar arVar, cb cbVar, TbPageTag tbPageTag) {
        if (!au.isEmpty(cbVar.mRecomWeight)) {
            arVar.dR("recom_weight", cbVar.mRecomWeight);
        }
        if (!au.isEmpty(cbVar.mRecomExtra)) {
            arVar.dR("recom_extra", cbVar.mRecomExtra);
        }
        if (!au.isEmpty(cbVar.mRecomSource)) {
            arVar.dR(IntentConfig.RECOM_SOURCE, cbVar.mRecomSource);
        }
        if (!au.isEmpty(cbVar.mRecomAbTag)) {
            arVar.dR("recom_ab_tag", cbVar.mRecomAbTag);
        }
        arVar.ap("recom_type", cbVar.bpR());
        com.baidu.tbadk.pageInfo.c.a(arVar, tbPageTag);
    }
}
