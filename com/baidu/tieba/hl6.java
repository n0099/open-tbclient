package com.baidu.tieba;

import android.text.Editable;
import android.text.Html;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
/* loaded from: classes6.dex */
public class hl6 implements Html.TagHandler, ContentHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XMLReader a;
    public ContentHandler b;
    public int c;
    public final boolean d;
    public final Map<String, fl6> e;

    public hl6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new HashMap();
        this.d = z;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!this.e.containsKey(str) || this.e.get(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b.endPrefixMapping(str);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, locator) == null) {
            this.b.setDocumentLocator(locator);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.b.skippedEntity(str);
        }
    }

    public final void b(String str, XMLReader xMLReader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, xMLReader) == null) {
            if (a(str)) {
                this.c--;
            }
            if (this.c == 0) {
                this.a.setContentHandler(this.b);
                this.a = null;
                this.b = null;
            }
        }
    }

    public void c(String str, fl6 fl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, fl6Var) == null) {
            this.e.put(str.toLowerCase(), fl6Var);
        }
    }

    public final void d(String str, XMLReader xMLReader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, xMLReader) == null) {
            if (a(str)) {
                this.c++;
            }
            if (this.b == null) {
                this.b = xMLReader.getContentHandler();
                this.a = xMLReader;
                xMLReader.setContentHandler(this);
            }
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.b.processingInstruction(str, str2);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            this.b.startPrefixMapping(str, str2);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, cArr, i, i2) == null) {
            this.b.characters(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, cArr, i, i2) == null) {
            this.b.ignorableWhitespace(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.endDocument();
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.startDocument();
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) {
            String lowerCase = str2.toLowerCase();
            if (lowerCase.equalsIgnoreCase("head")) {
                handleTag(false, lowerCase, null, this.a);
            } else if (a(lowerCase)) {
                this.e.get(lowerCase).a(this.d, lowerCase);
            }
        }
    }

    @Override // android.text.Html.TagHandler
    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), str, editable, xMLReader}) == null) {
            if (z) {
                d(str.toLowerCase(), xMLReader);
            } else {
                b(str.toLowerCase(), xMLReader);
            }
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, str3, attributes) == null) {
            String lowerCase = str2.toLowerCase();
            if (lowerCase.equalsIgnoreCase("head")) {
                handleTag(true, lowerCase, null, this.a);
            } else if (a(lowerCase)) {
                this.e.get(lowerCase).b(this.d, lowerCase, attributes);
            }
        }
    }
}
