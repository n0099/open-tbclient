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
    private boolean aYs = true;
    private ArrayList<String> aYt = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> aYu = new HashMap<>();
    private HashMap<String, Integer> aYv = new HashMap<>();

    public void Nm() {
        this.aYs = false;
    }

    public void Nn() {
        this.aYs = true;
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.aYu.remove(gid);
                this.aYu.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.aYt.add(gid);
                this.aYu.put(gid, imMessageCenterPojo);
                this.aYv.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.aYs && (size = this.aYt.size()) >= 4) {
                    for (String str : this.aYt.subList(0, size - 4)) {
                        this.aYt.remove(str);
                        this.aYu.remove(str);
                        this.aYv.remove(str);
                    }
                }
            }
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            gy(imMessageCenterPojo.getGid());
        }
    }

    public void gy(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYt.remove(str);
            this.aYt.add(str);
        }
    }

    public void gz(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYt.remove(str);
            this.aYv.remove(str);
            this.aYu.remove(str);
        }
    }

    public void removeAll() {
        this.aYt.clear();
        this.aYv.clear();
        this.aYu.clear();
    }

    public int No() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.aYu.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Np() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.aYt.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.aYu.get(this.aYt.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.aYu.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.aYv.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            gz(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (e(imMessageCenterPojo)) {
                b(imMessageCenterPojo);
                return 4;
            } else if (f(imMessageCenterPojo)) {
                if (this.aYt.contains(imMessageCenterPojo.getGid())) {
                    d(imMessageCenterPojo);
                    return 1;
                }
                c(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            gA(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Nr()) ? 6 : 0;
    }

    private void gA(String str) {
        if (!StringUtils.isNull(str) && this.aYv.containsKey(str)) {
            this.aYv.put(str, 0);
        }
    }

    public ArrayList<UserData> Nq() {
        if (this.aYt == null || this.aYt.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.aYt.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.aYu.get(this.aYt.get(i));
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

    public boolean Nr() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.aYu.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.aYt.remove(value.getGid());
                this.aYv.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Ns() {
        return (this.aYt == null || this.aYt.isEmpty()) ? false : true;
    }
}
