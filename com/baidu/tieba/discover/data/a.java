package com.baidu.tieba.discover.data;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.FoundNew.Banner;
import tbclient.FoundNew.FoundNewResIdl;
import tbclient.FoundNew.Menu;
import tbclient.FoundNew.Module;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.b, j {
    private long aKI;
    private Banner aKJ;
    private List<d> aKK;

    public long HI() {
        return this.aKI;
    }

    public Banner HJ() {
        return this.aKJ;
    }

    public List<d> HK() {
        return this.aKK;
    }

    public void G(List<d> list) {
        this.aKK = list;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "FoundNewData";
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message instanceof FoundNewResIdl) {
            FoundNewResIdl foundNewResIdl = (FoundNewResIdl) message;
            if (foundNewResIdl.error.errorno.intValue() == 0 && foundNewResIdl.data != null) {
                if (foundNewResIdl.data.timestamp != null) {
                    this.aKI = foundNewResIdl.data.timestamp.longValue();
                }
                this.aKJ = foundNewResIdl.data.banner;
                List<Module> list = foundNewResIdl.data.module;
                this.aKK = new ArrayList(0);
                if (list != null && !list.isEmpty()) {
                    for (Module module : list) {
                        if (module != null && module.menu_list != null && module.menu_list.size() > 0) {
                            d dVar = new d();
                            dVar.setType(module.type == null ? 0 : module.type.intValue());
                            ArrayList arrayList = new ArrayList(0);
                            dVar.H(arrayList);
                            for (Menu menu : module.menu_list) {
                                if (menu != null) {
                                    arrayList.add(new c().a(menu));
                                }
                            }
                            this.aKK.add(dVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Cz() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean R(byte[] bArr) {
        try {
            a((FoundNewResIdl) new Wire(new Class[0]).parseFrom(bArr, FoundNewResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
