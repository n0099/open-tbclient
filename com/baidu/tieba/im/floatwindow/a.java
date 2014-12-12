package com.baidu.tieba.im.floatwindow;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private boolean aWW = true;
    private ArrayList<String> aWX = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> aWY = new HashMap<>();
    private HashMap<String, Integer> aWZ = new HashMap<>();

    public void MQ() {
        this.aWW = false;
    }

    public void MR() {
        this.aWW = true;
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.aWY.remove(gid);
                this.aWY.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.aWX.add(gid);
                this.aWY.put(gid, imMessageCenterPojo);
                this.aWZ.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.aWW && (size = this.aWX.size()) >= 4) {
                    for (String str : this.aWX.subList(0, size - 4)) {
                        this.aWX.remove(str);
                        this.aWY.remove(str);
                        this.aWZ.remove(str);
                    }
                }
            }
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            gt(imMessageCenterPojo.getGid());
        }
    }

    public void gt(String str) {
        if (!StringUtils.isNull(str)) {
            this.aWX.remove(str);
            this.aWX.add(str);
        }
    }

    public void gu(String str) {
        if (!StringUtils.isNull(str)) {
            this.aWX.remove(str);
            this.aWZ.remove(str);
            this.aWY.remove(str);
        }
    }

    public void removeAll() {
        this.aWX.clear();
        this.aWZ.clear();
        this.aWY.clear();
    }

    public int MS() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.aWY.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> MT() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.aWX.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.aWY.get(this.aWX.get(i));
                if (imMessageCenterPojo != null) {
                    arrayList.add(imMessageCenterPojo.getGroup_head());
                }
            }
        }
        return arrayList;
    }

    private boolean e(ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterPojo imMessageCenterPojo2;
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.aWY.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.aWZ.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            gu(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (e(imMessageCenterPojo)) {
                b(imMessageCenterPojo);
                return 4;
            } else if (f(imMessageCenterPojo)) {
                if (this.aWX.contains(imMessageCenterPojo.getGid())) {
                    d(imMessageCenterPojo);
                    return 1;
                }
                c(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            gv(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && MV()) ? 6 : 0;
    }

    private void gv(String str) {
        if (!StringUtils.isNull(str) && this.aWZ.containsKey(str)) {
            this.aWZ.put(str, 0);
        }
    }

    public ArrayList<UserData> MU() {
        if (this.aWX == null || this.aWX.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.aWX.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.aWY.get(this.aWX.get(i));
            if (imMessageCenterPojo != null) {
                UserData userData = new UserData();
                userData.setUserId(imMessageCenterPojo.getGid());
                userData.setUserName(imMessageCenterPojo.getGroup_name());
                userData.setPortrait(imMessageCenterPojo.getGroup_head());
                if (i == size - 1) {
                    userData.setConcern_num(0);
                } else {
                    userData.setConcern_num(imMessageCenterPojo.getUnread_count());
                }
                userData.setIsFriend(imMessageCenterPojo.getIsFriend());
                arrayList.add(userData);
            }
        }
        return arrayList;
    }

    public boolean MV() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.aWY.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.aWX.remove(value.getGid());
                this.aWZ.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean MW() {
        return (this.aWX == null || this.aWX.isEmpty()) ? false : true;
    }
}
