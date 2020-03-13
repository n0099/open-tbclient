package com.baidu.tieba.ala.alasquare.a;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class b {
    public static Pair<List<m>, List<m>> e(String str, List<com.baidu.tieba.ala.alasquare.live.b.a> list) {
        if (v.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.baidu.tieba.ala.alasquare.live.b.a aVar : list) {
            if (aVar == null || v.isEmpty(aVar.live)) {
                arrayList2.add(aVar);
            } else {
                List<m> b = b(aVar);
                String str2 = aVar.entry_name;
                if (v.isEmpty(b) || b.size() < 2 || TextUtils.isEmpty(str2)) {
                    arrayList2.add(aVar);
                } else {
                    com.baidu.tieba.ala.alasquare.live.b.b bVar = new com.baidu.tieba.ala.alasquare.live.b.b();
                    bVar.tabId = aVar.eks;
                    bVar.entryName = str2;
                    bVar.labelName = aVar.label_name;
                    bVar.bitmapRatio = aVar.bitmap_wh_ratio;
                    bVar.categoryType = aVar.ekt;
                    bVar.eku = aVar.eku;
                    linkedList.add(bVar);
                    int size = b.size();
                    int i = size % 2 != 0 ? size - 1 : size;
                    aVar.live = aVar.live.subList(0, i);
                    for (int i2 = 0; i2 + 1 < i; i2 += 2) {
                        if ("1:1".equals(aVar.bitmap_wh_ratio)) {
                            com.baidu.tieba.ala.alasquare.subtablist.b.b bVar2 = new com.baidu.tieba.ala.alasquare.subtablist.b.b();
                            c cVar = (c) b.get(i2);
                            c cVar2 = (c) b.get(i2 + 1);
                            bVar2.emi = cVar;
                            bVar2.emj = cVar2;
                            arrayList.add(cVar);
                            arrayList.add(cVar2);
                            linkedList.add(bVar2);
                        } else if ("16:9".equals(aVar.bitmap_wh_ratio)) {
                            com.baidu.tieba.ala.alasquare.subtablist.b.a aVar2 = new com.baidu.tieba.ala.alasquare.subtablist.b.a();
                            c cVar3 = (c) b.get(i2);
                            c cVar4 = (c) b.get(i2 + 1);
                            aVar2.emi = cVar3;
                            aVar2.emj = cVar4;
                            arrayList.add(cVar3);
                            arrayList.add(cVar4);
                            linkedList.add(aVar2);
                        }
                    }
                }
            }
        }
        list.removeAll(arrayList2);
        return new Pair<>(linkedList, arrayList);
    }

    public static List<com.baidu.tieba.ala.alasquare.live.b.a> a(List<com.baidu.tieba.ala.alasquare.live.b.a> list, List<com.baidu.tieba.ala.alasquare.live.b.a> list2, boolean z) {
        if (list == null || list.isEmpty()) {
            return list2;
        }
        if (list2 != null && !list2.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            for (com.baidu.tieba.ala.alasquare.live.b.a aVar : list2) {
                if (aVar != null && !v.isEmpty(aVar.live) && !TextUtils.isEmpty(aVar.entry_name)) {
                    if (z) {
                        if (!a(aVar, list)) {
                            linkedList.add(aVar);
                        }
                    } else {
                        linkedList.add(aVar);
                    }
                }
            }
            if (z) {
                linkedList.addAll(0, list);
            }
            return linkedList;
        }
        return list;
    }

    private static boolean a(com.baidu.tieba.ala.alasquare.live.b.a aVar, List<com.baidu.tieba.ala.alasquare.live.b.a> list) {
        if (aVar == null || v.isEmpty(list)) {
            return false;
        }
        for (com.baidu.tieba.ala.alasquare.live.b.a aVar2 : list) {
            if (aVar.eks == aVar2.eks && aVar.entry_name.equals(aVar2.entry_name) && aVar.label_name.equals(aVar2.label_name)) {
                return true;
            }
        }
        return false;
    }

    public static List<com.baidu.tieba.ala.alasquare.live.b.a> bd(List<HotLiveWithCategory> list) {
        if (v.isEmpty(list)) {
            return new LinkedList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (HotLiveWithCategory hotLiveWithCategory : list) {
            if (hotLiveWithCategory != null) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live.b.a(hotLiveWithCategory));
            }
        }
        return arrayList;
    }

    private static String a(com.baidu.tieba.ala.alasquare.live.b.a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.eks + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        sb.append(aVar.entry_name + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        sb.append(aVar.label_name);
        return sb.toString();
    }

    public static void a(List<com.baidu.tieba.ala.alasquare.live.b.a> list, List<com.baidu.tieba.ala.alasquare.live.b.a> list2, List<Long> list3) {
        ThreadInfo threadInfo;
        if (!v.isEmpty(list2)) {
            HashMap hashMap = new HashMap(list2.size());
            for (com.baidu.tieba.ala.alasquare.live.b.a aVar : list2) {
                if (aVar != null) {
                    hashMap.put(a(aVar), aVar.live);
                }
            }
            for (com.baidu.tieba.ala.alasquare.live.b.a aVar2 : list) {
                if (aVar2 != null && !v.isEmpty(aVar2.live)) {
                    ArrayList<Integer> arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= aVar2.live.size()) {
                            break;
                        }
                        ThreadInfo threadInfo2 = aVar2.live.get(i2);
                        if (threadInfo2 != null) {
                            if (list3.contains(threadInfo2.ala_info.live_id)) {
                                arrayList.add(Integer.valueOf(i2));
                            } else {
                                arrayList2.add(threadInfo2.ala_info.live_id);
                            }
                        }
                        i = i2 + 1;
                    }
                    if (!v.isEmpty(arrayList)) {
                        List list4 = (List) hashMap.get(a(aVar2));
                        if (!v.isEmpty(list4)) {
                            ArrayList arrayList3 = new ArrayList();
                            for (Integer num : arrayList) {
                                int intValue = num.intValue();
                                if (intValue < aVar2.live.size()) {
                                    Iterator it = list4.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            threadInfo = null;
                                            break;
                                        }
                                        threadInfo = (ThreadInfo) it.next();
                                        if (threadInfo != null && !list3.contains(threadInfo.ala_info.live_id) && !arrayList2.contains(threadInfo.ala_info.live_id) && !arrayList3.contains(threadInfo.ala_info.live_id)) {
                                            break;
                                        }
                                    }
                                    if (threadInfo != null) {
                                        arrayList3.add(threadInfo.ala_info.live_id);
                                        aVar2.live.set(intValue, threadInfo);
                                    } else {
                                        aVar2.live.remove(intValue);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static List<m> b(com.baidu.tieba.ala.alasquare.live.b.a aVar) {
        List<ThreadInfo> list = aVar.live;
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && threadInfo.thread_type.intValue() == 49) {
                c cVar = new c();
                cVar.tabId = aVar.eks;
                cVar.entryName = aVar.entry_name;
                cVar.labelName = aVar.label_name;
                cVar.a(threadInfo);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }
}
