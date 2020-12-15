package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(by byVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        boolean z2;
        int i3;
        String str2;
        ar a2;
        if (byVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (byVar.bpj() == null || byVar.bpj().user_info == null || byVar.bpj().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && byVar.bpj().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(byVar.bpj().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = byVar.getThreadType() == 41;
                if (z4) {
                    if (byVar.bov() != null) {
                        str3 = byVar.bov().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (byVar.eMe) {
                        z = true;
                        str = byVar.getId();
                        i2 = 14;
                    }
                    if (byVar.eMr) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = byVar.eMs;
                        i3 = 17;
                    }
                    a2 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.FRS, "common_click", i, byVar.eHa, z2, str2, (String) null, i3);
                    if (a2 == null) {
                        a2.al("list_order", c.cJI().a(bVar));
                        if (byVar.bra()) {
                            a2.al("gua_type", 1);
                        } else if (byVar.bqV() != null) {
                            a2.al("gua_type", 2);
                            int indexOf = a2.getParams().indexOf("obj_locate");
                            if (indexOf >= 0) {
                                a2.getParams().remove(indexOf + 1);
                                a2.getParams().add(indexOf + 1, 16);
                            } else {
                                a2.al("obj_locate", 16);
                            }
                        } else {
                            a2.al("gua_type", 0);
                        }
                        a(a2, byVar, tbPageTag);
                        if (byVar.bra()) {
                            a2.al("gua_type", 1);
                        }
                        if (z3) {
                            a2.al("obj_isofficial", byVar.bpj().user_info.is_official);
                        }
                        if (z3 || byVar.eMe || byVar.eMr) {
                            a2.delete("thread_type");
                            a2.al("thread_type", byVar.getThreadType());
                        }
                        a(a2, tbPageTag, true);
                        com.baidu.tieba.t.c.dOf().b(bdUniqueId, a2);
                        d(byVar, i);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (byVar.eMe) {
            }
            if (byVar.eMr) {
            }
            a2 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.FRS, "common_click", i, byVar.eHa, z2, str2, (String) null, i3);
            if (a2 == null) {
            }
        }
    }

    private static void d(by byVar, int i) {
        ar arVar = null;
        switch (i) {
            case 2:
                arVar = com.baidu.tieba.t.a.a("c13692", byVar, 2);
                break;
        }
        TiebaStatic.log(arVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(by byVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        boolean z2;
        int i2;
        String str2;
        ar a2;
        if (byVar != null) {
            String str3 = null;
            int i3 = 0;
            boolean z3 = (byVar.bpj() == null || byVar.bpj().user_info == null || byVar.bpj().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && byVar.bpj().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(byVar.bpj().live_id);
                i3 = 4;
            }
            if (!z4) {
                z4 = byVar.getThreadType() == 41;
                if (z4) {
                    if (byVar.bov() != null) {
                        str3 = byVar.bov().getTaskId();
                    }
                    boolean z5 = z4;
                    i = 2;
                    str = str3;
                    z = z5;
                    if (byVar.eMe) {
                        z = true;
                        str = byVar.getId();
                        i = 14;
                    }
                    if (byVar.eMr) {
                        z2 = z;
                        i2 = i;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = byVar.eMs;
                        i2 = 17;
                    }
                    a2 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.FRS, "common_exp", byVar.eHa, z2, str2, (String) null, i2);
                    if (a2 == null) {
                        a2.al("list_order", c.cJI().a(bVar));
                        if (byVar.bra()) {
                            a2.al("gua_type", 1);
                        } else if (byVar.bqV() != null) {
                            a2.al("gua_type", 2);
                        } else {
                            a2.al("gua_type", 0);
                        }
                        a(a2, byVar, tbPageTag);
                        if (z3) {
                            a2.al("obj_isofficial", byVar.bpj().user_info.is_official);
                        }
                        if (z3 || byVar.eMe || byVar.eMr) {
                            a2.delete("thread_type");
                            a2.al("thread_type", byVar.getThreadType());
                        }
                        a(a2, tbPageTag, false);
                        com.baidu.tieba.t.c.dOf().a(bdUniqueId, com.baidu.tieba.t.a.a(byVar.getTid(), str2, "", byVar.getBaijiahaoData()), a2);
                        if (byVar.eMe) {
                            a(byVar, bdUniqueId, tbPageTag);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i = i3;
            str = str3;
            z = z6;
            if (byVar.eMe) {
            }
            if (byVar.eMr) {
            }
            a2 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.FRS, "common_exp", byVar.eHa, z2, str2, (String) null, i2);
            if (a2 == null) {
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
                    arVar.al("obj_name", i);
                }
            } else if (i > 0) {
                arVar.delete("obj_locate");
                arVar.al("obj_locate", i);
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
                    arVar.al("list_order", i2);
                }
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<q> list, ForumData forumData, int i) {
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
            ar a2 = com.baidu.tieba.t.a.a(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!au.isEmpty(forumData.getId())) {
                    a2.dY("fid", forumData.getId());
                }
                if (!au.isEmpty(forumData.getName())) {
                    a2.dY("fname", forumData.getName());
                }
                if (!au.isEmpty(forumData.getFirst_class())) {
                    a2.dY("first_dir", forumData.getFirst_class());
                }
                if (!au.isEmpty(forumData.getSecond_class())) {
                    a2.dY("second_dir", forumData.getSecond_class());
                }
            }
            a2.al("list_order", i2);
            com.baidu.tieba.t.c.dOf().b(bdUniqueId, a2);
        }
    }

    public static void a(by byVar, TbPageTag tbPageTag) {
        if (byVar != null) {
            ar dY = new ar("common_click").dY("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).al("obj_adlocate", 15).dY("obj_id", byVar.getId()).w("fid", byVar.getFid()).al("obj_floor", byVar.eHa).dY("tid", byVar.getId()).al("thread_type", byVar.getThreadType()).dY("first_dir", byVar.bqz()).dY("second_dir", byVar.bqA()).dY("nid", byVar.getNid());
            a(dY, byVar, tbPageTag);
            TiebaStatic.log(dY);
        }
    }

    private static void a(by byVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (byVar != null && bdUniqueId != null && byVar.eMe) {
            boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (byVar.bqg() && byVar.getFeedBackReasonMap() != null && !z) {
                ar dY = new ar("common_exp").dY("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).al("obj_adlocate", 15).dY("obj_id", byVar.getId()).al("obj_floor", byVar.eHa).w("fid", byVar.getFid()).al("thread_type", byVar.getThreadType()).dY("tid", byVar.getId()).dY("first_dir", byVar.bqz()).dY("second_dir", byVar.bqA());
                a(dY, byVar, tbPageTag);
                com.baidu.tieba.t.c.dOf().a(bdUniqueId, com.baidu.tieba.t.a.a(byVar.getTid(), "", "", byVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dY);
            }
        }
    }

    private static void a(ar arVar, by byVar, TbPageTag tbPageTag) {
        if (!au.isEmpty(byVar.mRecomWeight)) {
            arVar.dY("recom_weight", byVar.mRecomWeight);
        }
        if (!au.isEmpty(byVar.mRecomExtra)) {
            arVar.dY("recom_extra", byVar.mRecomExtra);
        }
        if (!au.isEmpty(byVar.mRecomSource)) {
            arVar.dY(IntentConfig.RECOM_SOURCE, byVar.mRecomSource);
        }
        if (!au.isEmpty(byVar.mRecomAbTag)) {
            arVar.dY("recom_ab_tag", byVar.mRecomAbTag);
        }
        arVar.al("recom_type", byVar.bqQ());
        com.baidu.tbadk.pageInfo.c.a(arVar, tbPageTag);
    }
}
