package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* loaded from: classes4.dex */
public class fd implements ad {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Element a;
    public Set<String> b;

    public fd(Element element) {
        String nodeName;
        String nodeName2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {element};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = element;
        this.b = new HashSet();
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i3 = 0; i3 < length; i3++) {
                Node item = attributes.item(i3);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.b.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i4 = 0; i4 < length2; i4++) {
                Node item2 = childNodes.item(i4);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.b.add(nodeName);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad
    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) || obj == null || str == null) {
            return;
        }
        if (obj instanceof Boolean) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Byte) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Character) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Short) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Long) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Float) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof String) {
            this.a.setAttribute(str, String.valueOf(obj));
        } else if (obj.getClass().isArray() || dc.e(obj.getClass(), List.class) || dc.e(obj.getClass(), Queue.class) || dc.e(obj.getClass(), Set.class) || dc.e(obj.getClass(), Map.class)) {
        } else {
            dc.e(obj.getClass(), SparseArray.class);
        }
    }

    @Override // com.baidu.tieba.ad
    public Object b(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, type)) == null) {
            Object c = c(str);
            if (c != null) {
                de deVar = new de(type);
                nd a = he.a(c);
                return a != null ? a.a(deVar) : c;
            }
            return c;
        }
        return invokeLL.objValue;
    }

    public Object c(String str) {
        InterceptResult invokeL;
        String nodeName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String attribute = this.a.getAttribute(str);
            if (TextUtils.isEmpty(attribute)) {
                NodeList childNodes = this.a.getChildNodes();
                int length = childNodes.getLength();
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    Node item = childNodes.item(i);
                    if (item != null && (nodeName = item.getNodeName()) != null && nodeName.equals(str)) {
                        arrayList.add(item);
                    }
                }
                return arrayList;
            }
            return attribute;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.ad
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (Set) invokeV.objValue;
    }
}
